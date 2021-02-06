package pjatk.project.beercalc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.service.CalcService;
import pjatk.project.beercalc.service.RecipeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;
    private CalcService calcService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> findAll() {
        List<Recipe> all = recipeService.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.saveRecipe(recipe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Recipe>> findById(@PathVariable Long id) {
        Optional<Recipe> byId = recipeService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> deleteAll() {
        recipeService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/calculateExtract/{id}")
    public ResponseEntity<Recipe> calculateExtract(@PathVariable Long id) {
        Recipe recipe = calcService.calcExtract(id);
        return ResponseEntity.ok(recipe);
    }
}
