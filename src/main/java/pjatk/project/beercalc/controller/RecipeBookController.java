package pjatk.project.beercalc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.project.beercalc.service.RecipeBookService;

@RestController
@RequestMapping("/recipebook")
public class RecipeBookController {
    private RecipeBookService recipeBookService;



}
