package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.gamesrating.app.model.Category;
import pl.gamesrating.app.service.CategoryService;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String createCategory(@RequestParam(required = false) Long id, @RequestParam String name){
        Category newCategory = new Category(id, name);
        newCategory = categoryService.createCategory(newCategory);
        return newCategory.toString();
    }
}
