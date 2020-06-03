package pl.gamesrating.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gamesrating.app.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
