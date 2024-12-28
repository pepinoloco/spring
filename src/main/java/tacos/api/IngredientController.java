package tacos.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import tacos.Ingredient;
import tacos.data.IngredientRepository;

@RestController
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping(path="/api/ingredients", produces="application/json")
public class IngredientController {
  private static final org.slf4j.Logger log =
    org.slf4j.LoggerFactory.getLogger(IngredientController.class);

  private IngredientRepository repo;

  @Autowired
  public IngredientController(IngredientRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public Iterable<Ingredient> getAll() {
    return repo.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Ingredient> getById(@PathVariable("id") String id) {
    return repo.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Ingredient postIngredient(@RequestBody Ingredient ingredient) {
    return repo.save(ingredient);
  }
}
