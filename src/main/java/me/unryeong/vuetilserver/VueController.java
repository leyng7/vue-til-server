package me.unryeong.vuetilserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.unryeong.vuetilserver.user.User;
import me.unryeong.vuetilserver.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequiredArgsConstructor
public class VueController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> users() {
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public LoginRes login(@RequestBody User user) {
        User findUser = userRepository.findByUsername(user.getUsername()).orElseThrow();
        return new LoginRes(true, findUser, "Login success", UUID.randomUUID().toString().replace("=", ""));
    }

    @Data
    @AllArgsConstructor
    private static class LoginRes {

        private boolean success;
        private User user;
        private String message;
        private String token;

    }

}
