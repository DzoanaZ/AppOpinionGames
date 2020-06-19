package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gamesrating.app.service.CategoryService;
import pl.gamesrating.app.service.PostService;


@Controller
public class MainController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String getIndexPage(Model model){

        model.addAttribute("news",postService.getNews());
        model.addAttribute("gameCategories", categoryService.getAllCategories());
        model.addAttribute("prepareFileDirectory", "/img/files");
        return "index";
    }
    @GetMapping(value = "/404")
    public String error404(Model model) {
        model.addAttribute("gameCategories", categoryService.getAllCategories());
        if (model.getAttribute("errorMessage") == null)
            model.addAttribute("errorMessage", "Error 404: Nie znaleziono takiej strony. Przejdź do strony głównej :)");
        return "error";
    }

    @GetMapping(value = "/403")
    public String error403(Model model) {
        model.addAttribute("gameCategories", categoryService.getAllCategories());
        model.addAttribute("errorMessage", "Error 403: Brak dostępu do treści. Przejdź do strony głównej :)");
        return "error";
    }
}
