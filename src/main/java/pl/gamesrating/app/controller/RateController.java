package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gamesrating.app.model.DTO.RatingDTO;
import pl.gamesrating.app.model.User;
import pl.gamesrating.app.repository.UserRepository;
import pl.gamesrating.app.service.RateService;


@Controller
public class RateController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RateService rateService;

    @PostMapping(value = "/user/rating/new/{id}")
    public String createNewRating(RatingDTO ratingDto, @PathVariable("id") Long postId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null)
            user = userRepository.findByEmail(auth.getName());

        if (user != null) {
            rateService.createNewRate(ratingDto, postId, user);
        }
        return "redirect:/post/" + postId;
    }
}
