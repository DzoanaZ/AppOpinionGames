package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gamesrating.app.model.DTO.PostDTO;
import pl.gamesrating.app.model.User;
import pl.gamesrating.app.repository.UserRepository;
import pl.gamesrating.app.service.CategoryService;
import pl.gamesrating.app.service.PostService;

import javax.validation.Valid;

@Controller
public class PostController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;

    @GetMapping("/admin/post/new") //żądanie na formularz dodawania recenzji(postu)
    public String getNewPost(Model model){
        model.addAttribute("gameCategories", categoryService.getAllCategories());
        model.addAttribute("newPost", new PostDTO());
        return "new_post";
    }

    @PostMapping("/admin/post/new") //przesłanie danych z formularza
    public String createNewPost(@ModelAttribute ("newPost") @Valid PostDTO postDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null){
            user = userRepository.findByEmail(auth.getName());
        }
        if (user != null){
            postService.savePost(postDTO, user);
        }
        return "redirect:/"; //przekierowanie na stronę główną
    }
}
