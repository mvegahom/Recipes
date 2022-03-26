package recipes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import recipes.Error.RecipeNotFoundException;
import recipes.Model.Recipe;
import recipes.Model.User;
import recipes.Repository.RecipeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    //    @Autowired
//    RecipeStore store;
    @Autowired
    RecipeRepository recipeRepository;

    public Recipe getRecipeById(long id) throws RecipeNotFoundException {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElseThrow(RecipeNotFoundException::new);
    }

    public Long saveRecipe(Recipe recipe, User user) {
        recipe.setUser(user);
        recipe.setDate(LocalDateTime.now());
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    public boolean isRecipeStored(long id) throws RecipeNotFoundException{
        if (!recipeRepository.existsById(id))
            throw new RecipeNotFoundException();
        return true;
    }

    public ResponseEntity deleteRecipeById(long id) {
        try {
            isRecipeStored(id);
            recipeRepository.deleteById(id);
            return new ResponseEntity("No Content", HttpStatus.NO_CONTENT);
        } catch (RecipeNotFoundException e) {
            return e.getResponseEntity();
        }
    }

    public ResponseEntity updateRecipeById(long id, Recipe recipe) {
        try {
            isRecipeStored(id);
            Recipe toUpdate = recipeRepository.findById(id).get();
            toUpdate.Update(recipe);
            recipeRepository.save(toUpdate);
            return new ResponseEntity("No Content", HttpStatus.NO_CONTENT);
        } catch (RecipeNotFoundException e) {
            return e.getResponseEntity();
        }
    }

    public ResponseEntity searchUsingCategory(String category) {
        List<Recipe> recipes = recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
        return new ResponseEntity(recipes, HttpStatus.OK);
    }

    public ResponseEntity searchUsingName(String name) {
        List<Recipe> recipes = recipeRepository.findAllByNameContainsIgnoreCaseOrderByDateDesc(name);
        return new ResponseEntity(recipes, HttpStatus.OK);
    }
}