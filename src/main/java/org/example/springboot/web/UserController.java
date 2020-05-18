package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.dto.User.UserDTO;
import org.example.springboot.dto.User.UserInfoDTO;
import org.example.springboot.dto.User.UserLoginDTO;
import org.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public Long saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/user")
    public int chkUser(@RequestParam("data") String data, @RequestParam("type") String type) {
        return userService.chkUser(data, type);
    }

    @GetMapping("/salt")
    public String getSalt(@RequestParam("data") String data) {
        return userService.getSalt(data);
    }

    @PostMapping("/login")
    public int login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    @GetMapping("/code")
    public String getCode(@RequestParam("data") String data) {
        return userService.getAuth(data);
    }

    @GetMapping("/auth")
    public Boolean getAuth(@RequestParam("data") String data) {
        return userService.getAuth(data).equals("0");
    }

    @GetMapping("/chkCode")
    public Boolean chkCode(@RequestParam("code") String code) {
        return userService.chkCode(code);
    }

    @GetMapping("/email")
    public String getEmail(@RequestParam("data") String data) {
        return userService.getEmail(data);
    }

    @GetMapping("/fav/press")
    public List<String> getFavPress(@RequestParam("id") String id) {return userService.getFavPress(id);}

    @GetMapping("/set")
    public boolean checkSet(@RequestParam("id") String id) {
        return userService.checkSet(id);
    }

    @GetMapping("/set/comment")
    public void commentSet(@RequestParam("id") String id) {
        userService.commentSet(id);
    }

    @GetMapping("/user/info")
    public UserInfoDTO getUserInfo(@RequestParam("id") String id) { return userService.getUserInfo(id); }
}
