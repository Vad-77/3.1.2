package ru.vadim.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vadim.springcourse.model.User;
import ru.vadim.springcourse.servies.UserService;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "userList";
    }

    @GetMapping ("/users/new")
    public String newUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }
    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
    @PostMapping("/users/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        Long userId = user.getId();
        boolean deleted = userService.delete(userId);
        if (deleted) {
            return "redirect:/users";
        } else {
            return "userNotFound";
        }
    }
    @GetMapping("/users/edit")
    public String editUserForm(@RequestParam("id") Long userId, ModelMap model) {
        User userToEdit = userService.getUserById(userId);
        model.addAttribute("user", userToEdit);
        return "editUser";
    }
    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
