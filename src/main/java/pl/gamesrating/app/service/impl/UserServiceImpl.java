package pl.gamesrating.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gamesrating.app.exception.EmailExistsException;
import pl.gamesrating.app.exception.PasswordMatchingException;
import pl.gamesrating.app.model.DTO.UserDTO;
import pl.gamesrating.app.model.Role;
import pl.gamesrating.app.model.User;
import pl.gamesrating.app.repository.RoleRepository;
import pl.gamesrating.app.repository.UserRepository;
import pl.gamesrating.app.service.UserService;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User createNewUser(UserDTO userDto) throws EmailExistsException, PasswordMatchingException {
        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + userDto.getEmail());
        }

        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            throw new PasswordMatchingException("Passwords do not match!");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setActive(1);

        this.addUserRole(user);
        //this.addAdminRole(user);

        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    public void addUserRole(User user) {
        addRole(user, "ROLE_USER");
    }

    public void addAdminRole(User user) {
        addRole(user, "ROLE_ADMIN");
    }

    private void addRole(User user, String roleName) {
        HashSet<Role> userRoles = (HashSet<Role>) user.getRoles();
        if (userRoles == null || userRoles.isEmpty())
            userRoles = new HashSet<>();

        for (Role newRole : roleRepository.findAll())
            if (newRole.getRole().equals(roleName)) {
                userRoles.add(newRole);
            }

        user.setRoles(userRoles);
    }
}