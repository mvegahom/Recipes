package recipes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.Error.RecipeNotFoundException;
import recipes.Model.Recipe;
import recipes.Model.User;
import recipes.Service.RecipeService;
import recipes.Service.UserService;

import javax.validation.Valid;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Validated
@RequestMapping("/api/recipe")
public class RecipesController {
    @Autowired
    RecipeService recipeService;

    @Autowired
    UserService userService;

    @PostMapping("/new")
    public ResponseEntity saveNewRecipe(@AuthenticationPrincipal User user, @RequestBody @Valid Recipe recipe) {
        if (userService.userExist(user.getUsername())) {
            try {
                Long id = recipeService.saveRecipe(recipe, user);
                return new ResponseEntity(Map.of("id", id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getRecipeById(@PathVariable long id) {
        try {
            return new ResponseEntity(recipeService.getRecipeById(id), HttpStatus.OK);
        } catch (RecipeNotFoundException e) {
            return e.getResponseEntity();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecipeById(@AuthenticationPrincipal User user, @PathVariable long id) {
        System.out.println("Auth user " + user);
        try {
            Recipe recipe = recipeService.getRecipeById(id);
            System.out.println(recipe);
            User recipeOwner = recipe.getUser();
            System.out.println("Recipe owner " + recipeOwner);
            if (recipeOwner.getId() != user.getId()) {
                System.out.println("Not equals");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            } else {
                System.out.println("Deleting recipe");
                return recipeService.deleteRecipeById(id);
            }
        } catch (RecipeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRecipeById(@AuthenticationPrincipal User user, @PathVariable long id, @RequestBody @Valid Recipe recipe) {
        System.out.println("Auth user " + user);
        try {
            System.out.println("Recipe Argument" + recipe);
            Recipe olderRecipe = recipeService.getRecipeById(id);
            User recipeOwner = olderRecipe.getUser();
            System.out.println("Recipe owner " + recipeOwner);
            if (recipeOwner.getId() != user.getId()) {
                System.out.println("Not equals");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            } else {
                System.out.println("Updating recipe");
                return recipeService.updateRecipeById(id, recipe);
            }
        } catch (Exception e) {
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        } catch (RecipeNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity searchUsingProperty(@RequestParam(required = false) Map<String, String> parameter) {
        if (parameter.isEmpty() || parameter.size() > 1)
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        if (parameter.containsKey("category"))
            return recipeService.searchUsingCategory(parameter.get("category"));
        else if (parameter.containsKey("name"))
            return recipeService.searchUsingName(parameter.get("name"));
        else
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
    }
}