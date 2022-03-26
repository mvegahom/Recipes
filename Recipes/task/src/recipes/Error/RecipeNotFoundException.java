package recipes.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RecipeNotFoundException extends RecipeException{

    public RecipeNotFoundException() {
        super(new ResponseEntity("Not found", HttpStatus.NOT_FOUND));
    }
}

/*

package recipes.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Recipe not found")
public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException() {
        super();
    }
}

*/