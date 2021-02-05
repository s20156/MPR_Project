package pjatk.project.beercalc.service;

import org.springframework.stereotype.Service;
import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() { return recipeRepository.findAll(); }


    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }
}
