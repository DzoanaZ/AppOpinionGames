package pl.gamesrating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gamesrating.app.exception.EmailExistsException;
import pl.gamesrating.app.exception.PasswordMatchingException;
import pl.gamesrating.app.model.DTO.UserDTO;
import pl.gamesrating.app.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/account/new")
    public String registerNewUser(@ModelAttribute("userDto") @Valid UserDTO userDTO, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                userService.createNewUser(userDTO);

            } catch (PasswordMatchingException e) {
                result.rejectValue("email", e.getMessage());
            } catch (EmailExistsException e) {
                result.rejectValue("password", e.getMessage());
            }
        }
        if (result.hasErrors()) {
            return "redirect:/?registrationFiled";
        } else
            return "redirect:/?registrationSuccessful";
    }
}
