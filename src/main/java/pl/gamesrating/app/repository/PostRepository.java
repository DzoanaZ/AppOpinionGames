package pl.gamesrating.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gamesrating.app.model.Post;

import java.util.List;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findTop4ByOrderByPublicationDateDesc();
}
