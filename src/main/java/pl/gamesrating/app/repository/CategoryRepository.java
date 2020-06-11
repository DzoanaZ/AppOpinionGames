package pl.gamesrating.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gamesrating.app.model.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Iterable<Category> findAllByNameIgnoreCase(String name);
}
