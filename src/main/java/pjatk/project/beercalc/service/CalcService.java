package pjatk.project.beercalc.service;

import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.repository.RecipeRepository;

import java.util.Optional;

public class CalcService {
    private RecipeRepository recipeRepository;

    public CalcService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe calcExtract(Long recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (recipe.isPresent()) {
            recipe.get().setExtract(recipe.get().getMaltAmount()*0.7/recipe.get().getTargetVolume());
            return recipeRepository.save(recipe.get());
        } else {
            return null;
        }
    }

    public Recipe calcIBU(Long recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (recipe.isPresent()) {
            recipe.get().setIBU((int) (recipe.get().getHopAmount()*recipe.get().getHopAlfaAcids()));
            return recipeRepository.save(recipe.get());
        } else {
            return null;
        }
    }
}
