package pjatk.project.beercalc.service;

import org.springframework.stereotype.Service;
import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() { return recipeRepository.findAll(); }
}
