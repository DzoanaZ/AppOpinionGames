package pl.gamesrating.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gamesrating.app.model.DTO.RatingDTO;
import pl.gamesrating.app.model.Post;
import pl.gamesrating.app.model.Rating;
import pl.gamesrating.app.model.Role;
import pl.gamesrating.app.model.User;
import pl.gamesrating.app.repository.PostRepository;
import pl.gamesrating.app.repository.RatingRepository;
import pl.gamesrating.app.service.RateService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createNewRate(RatingDTO ratingDTO, Long postId, User user) {
        Rating ratingNew = new Rating();
        Set<Role> userRoles = user.getRoles();
        Set<String> userRolesName = new HashSet<>();
        for (Role role : userRoles) {
            userRolesName.add(role.getRole());
        }

        ratingNew.setRatingDate(LocalDateTime.now());
        ratingNew.setRating(ratingDTO.getRating());
        ratingNew.setUser(user);
        ratingNew.setComment(ratingDTO.getComment());
        if (postRepository.findById(postId).isPresent())
            ratingNew.setPost(postRepository.findById(postId).get());
        if (userRolesName.contains("ROLE_USER"))
            ratingNew.setType(Rating.Type.USER);
        if (userRolesName.contains("ROLE_ADMIN"))
            ratingNew.setType(Rating.Type.EDITORIAL);

        ratingNew = ratingRepository.save(ratingNew);
        calculatePostRating(ratingNew, postId);
        return ratingNew;
    }

    private void calculatePostRating(Rating rating, Long postId) {
        if (postRepository.findById(postId).isPresent() & rating != null) {
            Post post = postRepository.findById(postId).get();
            double sum = 0;
            int i = 0;
            switch (rating.getType()) {
                case EDITORIAL:
                    for(Rating tmp : post.getEditorialsRatings()) {
                        sum += tmp.getRating();
                        ++i;
                    }
                    if(!post.getEditorialsRatings().contains(rating)) {
                        sum += rating.getRating();
                        ++i;
                    }
                    post.setEditorialRate(sum/(double)i);
                    break;
                case USER:
                    for(Rating tmp : post.getUsersRatings()) {
                        sum += tmp.getRating();
                        ++i;
                    }
                    if(!post.getUsersRatings().contains(rating)) {
                        sum += rating.getRating();
                        ++i;
                    }
                    post.setUsersRate(sum/(double)i);
                    break;
            }
            postRepository.save(post);
        }
    }
}
