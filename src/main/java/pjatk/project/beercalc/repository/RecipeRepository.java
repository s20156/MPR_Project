package pjatk.project.beercalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjatk.project.beercalc.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
}
