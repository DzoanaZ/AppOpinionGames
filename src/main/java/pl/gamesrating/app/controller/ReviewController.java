package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.gamesrating.app.model.Category;
import pl.gamesrating.app.service.CategoryService;
import pl.gamesrating.app.service.PostService;

@Controller
public class ReviewController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;

    @GetMapping(value = "/reviews")
    public String getReviews(Model model) {
        model.addAttribute("gameCategories",  categoryService.getAllCategories());
        model.addAttribute("prepareFileDirectory", "/img/files");
        model.addAttribute("postsList", postService.getAllPosts());
        return "reviews";
    }

    @GetMapping(value = "/reviews/type/{id}")
    public String getReviewsByType(Model model, @PathVariable("id") long catId) {
        model.addAttribute("gameCategories",  categoryService.getAllCategories());

        Category category = categoryService.getCategoryById(catId);
        if (category!=null) {
            model.addAttribute("prepareFileDirectory", "/img/files");
            model.addAttribute("postsList", category.getPosts());
        }
        else {
            return "redirect:/404";
        }

        return "reviews";
    }
}
