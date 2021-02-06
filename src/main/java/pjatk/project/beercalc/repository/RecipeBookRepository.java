package pjatk.project.beercalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjatk.project.beercalc.model.Recipe;

import java.util.List;

public interface RecipeBookRepository extends JpaRepository<List<Recipe>, Long> {
}
