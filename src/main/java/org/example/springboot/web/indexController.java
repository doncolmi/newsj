package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.dto.User.UserDTO;
import org.example.springboot.service.User.UserService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
public class indexController {
    private final UserService userService;

    @PostMapping("/user")
    public Long saveUser(@RequestBody JSONObject user) {
        return userService.saveUser(new UserDTO((String) user.get("UID"), (String) user.get("PASSWORD"), (String) user.get("EMAIL")));
    }
}
