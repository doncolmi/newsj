package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.User;
import org.example.springboot.dto.User.UserDTO;
import org.example.springboot.service.User.UserService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@AllArgsConstructor
public class indexController {
    private final UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam String uid) {
        return userService.getUser(uid);
    }

    @PostMapping("/user")
    public Long saveUser(@RequestBody JSONObject user) {
        return userService.saveUser(new UserDTO((String) user.get("uid"), (String) user.get("password"), (String) user.get("email")));
    }
}
