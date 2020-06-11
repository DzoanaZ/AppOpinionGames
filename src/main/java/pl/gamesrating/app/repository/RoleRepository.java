package pl.gamesrating.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gamesrating.app.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
