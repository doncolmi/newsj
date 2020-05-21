package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.UsersData.Fav_Press;
import org.example.springboot.domain.UsersData.Fav_Topic;
import org.example.springboot.dto.User.UserPwDTO;
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
        return "1";
    }

    @GetMapping("/find/id")
    public String findId(@RequestParam("email") String email) {
        return userService.findId(email);
    }
    @GetMapping("/find/pw")
    public String findPw(@RequestParam("email") String email,@RequestParam("id") String id) {
        return userService.findPw(email, id);
    }
    @PostMapping("/find/pw")
    public Boolean changePw(@RequestBody UserPwDTO userPwDTO) {
         return userService.changePw(userPwDTO);
    }
    @GetMapping("/find/pw/auth")
    public Boolean findPwAuth(@RequestParam("code") String code) {
        return userService.findPwAuth(code);
    }

    @GetMapping("/follow/press")
    public List<Fav_Press> getFollowPress(@RequestParam String id) { return userService.getFollowPress(id); }

    @GetMapping("/follow/topic")
    public List<Fav_Topic> getFollowTopic(@RequestParam String id) { return userService.getFollowTopic(id); }

    @GetMapping("/bye")
    public void bye(@RequestParam String id) { userService.bye(id); }
}


