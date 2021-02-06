package pjatk.project.beercalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.repository.RecipeRepository;

import java.util.Optional;

@Service
public class CalcService {
    private RecipeRepository recipeRepository;

    public CalcService() {
    }

    @Autowired
    public CalcService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe calcExtract(Long recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (recipe.isPresent()) {
            recipe.get().setExtract(recipe.get().getTargetVolume()*3/recipe.get().getMaltAmount());
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

    public Recipe calcMetricToImperial(Recipe recipe) {
        recipe.setTargetVolume(recipe.getTargetVolume() * 0.264);
        return recipe;
    }
}
