package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.dto.User.UserDTO;
import org.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public Long saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

}
