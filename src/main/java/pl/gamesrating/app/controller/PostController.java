package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gamesrating.app.model.DTO.PostDTO;
import pl.gamesrating.app.model.Post;
import pl.gamesrating.app.model.User;
import pl.gamesrating.app.repository.UserRepository;
import pl.gamesrating.app.service.CategoryService;
import pl.gamesrating.app.service.PostService;

import javax.validation.Valid;
import java.io.IOException;

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
    public String createNewPost(@ModelAttribute ("newPost") @Valid PostDTO postDTO, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null){
            user = userRepository.findByEmail(auth.getName());
        }
        if (user != null){
            try {
                postService.savePost(postDTO, user);
            } catch (IOException e) {
                model.addAttribute("errorMessage", "Błąd podczas zapisywania pliku: " + e.getMessage());
                return "redirect:/404";
            }
        }
        return "redirect:/"; //przekierowanie na stronę główną
    }
    @GetMapping(value = "/post/{id}")
    public String getSinglePost(Model model, @PathVariable("id") Long postId) {
        model.addAttribute("gameCategories",categoryService.getAllCategories());
        //Post post = postRepository.findById(postId).isPresent() ? postRepository.findById(postId).get() : null;
        Post post = postService.findById(postId);
        if (post == null)
            return "redirect:/404";
        model.addAttribute("singlePost", post);
        model.addAttribute("prepareFileDirectory", "/img/files");
        return "review_post";
    }

    @GetMapping(value = "/admin/post/delete/{id}")
    public String deletePostById(@PathVariable("id") long postId) {

            Post post = postService.findById(postId);
            if(post!=null) {
                postService.delete(post);
            }
        return "redirect:/";
    }
}
