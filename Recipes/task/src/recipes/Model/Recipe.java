package recipes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "recipe", indexes = @Index(columnList = "category"))
public class Recipe {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "category can not be blank")
    private String category;

    @NotBlank(message = "name can not be blank")
    private String name;

    @NotBlank(message = "description can not be blank")
    private String description;

    @NotEmpty(message = "ingredients can not be empty")
    @Size(min = 1, message = "ingredients must >= 1")
    private String[] ingredients;

    @NotEmpty(message = "directions can not be empty")
    @Size(min = 1, message = "ingredients must >= 1")
    private String[] directions;

    @Column(name = "last_updated")
    // @UpdateTimestamp // use this to avoid setting the time manually.
    private LocalDateTime date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Recipe() {}

    public Recipe(String name, String description, String[] ingredients, String[] directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", directions=" + Arrays.toString(directions) +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setDirections(String[] directions) {
        this.directions = directions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getDirections() {
        return directions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime lastUpdated) {
        this.date = lastUpdated;
    }

    public void Update(Recipe recipe) {
        this.category = recipe.category;
        this.description = recipe.description;
        this.directions = recipe.directions;
        this.ingredients = recipe.ingredients;
        this.name = recipe.name;
        this.date = LocalDateTime.now();
    }
}