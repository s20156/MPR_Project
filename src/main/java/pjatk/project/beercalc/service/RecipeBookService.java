package pjatk.project.beercalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.project.beercalc.model.Recipe;
import pjatk.project.beercalc.repository.RecipeBookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeBookService {
    private RecipeBookRepository recipeBookRepository;

    @Autowired
    public RecipeBookService(RecipeBookRepository recipeBookRepository) {
        this.recipeBookRepository = recipeBookRepository;
    }

    public List<List<Recipe>> findAll() {
        return recipeBookRepository.findAll();
    }

    public Optional<List<Recipe>> findById(Long id) {
        return recipeBookRepository.findById(id);
    }
}
