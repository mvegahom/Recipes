package recipes.Error;

import org.springframework.http.ResponseEntity;

public class RecipeException extends Throwable {
    private ResponseEntity responseEntity;

    public RecipeException(ResponseEntity responseEntity) {
        this.responseEntity = responseEntity;
    }

    public ResponseEntity getResponseEntity() {
        return responseEntity;
    }
}