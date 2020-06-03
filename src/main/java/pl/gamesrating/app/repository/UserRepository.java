package pl.gamesrating.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gamesrating.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
}
