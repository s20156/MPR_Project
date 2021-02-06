package pjatk.project.beercalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    public RecipeController(RecipeService recipeService, CalcService calcService) {
        this.recipeService = recipeService;
        this.calcService = calcService;
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

    @PutMapping("/getGallons/{id}")
    public ResponseEntity<Recipe> calculateGallons(@PathVariable Long id) {
        Recipe recipe = calcService.calcMetricToImperial(recipeService.findById(id).get());
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/calculateExtract/{id}")
    public ResponseEntity<Recipe> calculateExtract(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        calcService.calcExtract(id);
        if(recipe.isPresent()) {
            return ResponseEntity.ok(recipe.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/calculateIBU/{id}")
    public ResponseEntity<Recipe> calculateIBU(@PathVariable Long id) {
        Recipe recipe = calcService.calcIBU(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
