package pl.gamesrating.app.service;

import pl.gamesrating.app.model.DTO.RatingDTO;
import pl.gamesrating.app.model.Rating;
import pl.gamesrating.app.model.User;

public interface RateService {
    Rating createNewRate(RatingDTO ratingDTO, Long postId, User user);
}
