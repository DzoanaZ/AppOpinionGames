package pl.gamesrating.app.service;

import pl.gamesrating.app.exception.EmailExistsException;
import pl.gamesrating.app.exception.PasswordMatchingException;
import pl.gamesrating.app.model.DTO.UserDTO;
import pl.gamesrating.app.model.User;

public interface UserService  {
    User createNewUser(UserDTO userDto) throws EmailExistsException, PasswordMatchingException;
    void addUserRole(User user);
    void addAdminRole(User user);
}
