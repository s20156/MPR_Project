package pjatk.project.beercalc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pjatk.project.beercalc.model.Recipe;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class RecipeServiceTestIT {
    @Autowired
    private RecipeService recipeService;
    private CalcService calcService;

    @Test
    void cleanup() {
        recipeService.deleteAll();
    }

    @Test
    void shouldFindRecipies() {
        Recipe recipe = recipeService.saveRecipe(new Recipe("test", 5, 20, 35, 30));
        List<Recipe> recipies = recipeService.findAll();
        assertThat(recipies).isNotEmpty();
    }

    @Test
    void shouldRecipiesBeEmpty() {
        List<Recipe> recipies = recipeService.findAll();
    }
}
