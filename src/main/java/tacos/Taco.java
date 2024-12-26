package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {

  private Long id;

  private Date createdAt;

  @NotNull
  @Size(min=5, message="Name must be at least 5 chars")
  private String name;

  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<IngredientRef> ingredients = new ArrayList<>();

  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(new IngredientRef(ingredient.getId()));
  }
}
