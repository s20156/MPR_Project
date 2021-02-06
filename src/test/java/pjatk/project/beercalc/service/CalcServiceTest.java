package pjatk.project.beercalc.service;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.util.Assert;
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
        when(recipeRepository.findById(recipe.getId())).thenReturn(Optional.of(recipe));
        calcService.calcExtract(recipe.getId());
        //then
        assertThat(recipe.getExtract()).isEqualTo(12);
    }

    @Test
    void shouldCalcIBU() {
        //given
        Recipe recipe = new Recipe("test", 5, 20, 60, 12, 30);
        //when
        when(recipeRepository.findById(recipe.getId())).thenReturn(Optional.of(recipe));
        calcService.calcIBU(recipe.getId());
        //then
        assertThat(recipe.getIBU()).isGreaterThan(0);
    }

    @Test
    void shouldCalcMetricToImperialProperly() {
        //given
        Recipe recipe = new Recipe("test", 5.5, 100.0, 220, 30);
        //when
        recipe = calcService.calcMetricToImperial(recipe);
        //then
        assertThat(recipe.getTargetVolume()).isCloseTo(26.4, Percentage.withPercentage(0.02));
    }
}