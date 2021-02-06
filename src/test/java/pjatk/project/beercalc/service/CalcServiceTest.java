package pjatk.project.beercalc.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import pjatk.project.beercalc.model.Recipe;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pjatk.project.beercalc.repository.RecipeRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalcServiceTest {
    @Mock
    private RecipeRepository recipeRepository;
    @InjectMocks
    private CalcService calcService;

    @Test
    void shouldCalcExtract() {
        //given
        Recipe recipe = new Recipe("test", 5, 20, 60, 30);
        //when
        recipeRepository.save(recipe);
        Optional<Recipe> recipeFromDB = recipeRepository.findById(recipe.getId());
        calcService.calcExtract(recipeFromDB.get().getId());
        //then
        assertThat(recipeFromDB.get().getExtract()).isEqualTo(12);
    }

    @Test
    void shouldCalcMetricToImperialProperly() {
        //given
        Recipe recipe = new Recipe("test", 5.5, 100.0, 220, 30);
        //when
        recipe = calcService.calcMetricToImperial(recipe);
        //then
        assertThat(recipe.getExtract()).isEqualTo(26.4);
    }
}