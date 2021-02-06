package pjatk.project.beercalc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.service.RecipeBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipebook")
public class RecipeBookController {
    private RecipeBookService recipeBookService;

    @GetMapping
    public ResponseEntity<List<List<Recipe>>> findAll() {
        List<List<Recipe>> all = recipeBookService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<Recipe>>> findById(@PathVariable Long id) {
        Optional<List<Recipe>> byId = recipeBookService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
