package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.User;
import org.example.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class indexController {
    private final UserService userService;

    @GetMapping("/status")
    public String status() {
        return "";
    }

    @GetMapping("/find/id")
    public String findId(@RequestParam("email") String email) {
        return userService.findId(email);
    }
    @GetMapping("/find/pw")
    public String findPw(@RequestParam("email") String email,@RequestParam("id") String id) {
        return userService.findPw(email, id);
    }
    @GetMapping("/find/pw/auth")
    public Boolean findPwAuth(@RequestParam("auth") String auth) {
        return userService.findPwAuth(auth);
    }
}


