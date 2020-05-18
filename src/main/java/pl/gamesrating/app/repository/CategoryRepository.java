package pl.gamesrating.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gamesrating.app.DAO.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
