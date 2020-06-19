package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.gamesrating.app.model.Category;
import pl.gamesrating.app.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categories") //wyświetlanie wszystkich kategorii w formularzu
    public String categoriesForm(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "edit_categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        //nie musimy sprawdzać uprawnień użytkownika bo do /admin ma dostęp tylko admin
        if (id > 0) {
            Category cat = categoryService.getCategoryById(id);
            if (cat != null) {
                categoryService.deleteCategory(cat);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/admin/categories/new")
    public ResponseEntity saveOrUpdate(@RequestParam Long id, @RequestParam String name) {
        Category cat = null;
        if (id > 0) {
            cat = categoryService.getCategoryById(id);
            cat.setName(name);

            //noinspection ConstantConditions
            if (cat != null) {
                categoryService.createCategory(cat);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                categoryService.createCategory(new Category(id,name));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
