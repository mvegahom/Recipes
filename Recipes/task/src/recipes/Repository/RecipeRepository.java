package recipes.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.Model.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    public List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

    public List<Recipe> findAllByNameContainsIgnoreCaseOrderByDateDesc(String name);
}