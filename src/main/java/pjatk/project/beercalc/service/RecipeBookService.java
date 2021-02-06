package pjatk.project.beercalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.project.beercalc.repository.RecipeBookRepository;

@Service
public class RecipeBookService {
    private RecipeBookRepository recipeBookRepository;

    @Autowired
    public RecipeBookService(RecipeBookRepository recipeBookRepository) {
        this.recipeBookRepository = recipeBookRepository;
    }
}
