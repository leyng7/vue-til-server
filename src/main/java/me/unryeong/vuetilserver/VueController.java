package me.unryeong.vuetilserver;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class VueController {

    @GetMapping("/signup")
    public UserForm test() {
        UserForm userForm = new UserForm();
        userForm.setNickname("TEST");
        return userForm;
    }

    @PostMapping("/signup")
    public UserForm signup(@RequestBody UserForm userForm) {
        return userForm;
    }

    @Data
    private static class UserForm {

        private String username;
        private String password;
        private String nickname;

    }

}
