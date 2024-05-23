package kmichalski.tanksCompetition.controller;

import kmichalski.tanksCompetition.model.User;
import kmichalski.tanksCompetition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register-new-user")
    String registerNewUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return "User with id:" + registeredUser.getId() + " has been registered";
    }
}
