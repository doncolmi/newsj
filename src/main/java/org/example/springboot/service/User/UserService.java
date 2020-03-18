package org.example.springboot.service.User;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.User.UserRepository;
import org.example.springboot.dto.User.UserDTO;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDTO userDTO) {
        return userRepository.save(userDTO.toEntity()).getId();
    }

    @Transactional
    public JSONObject getUser(String uid) {
        JSONObject user = new JSONObject();
        try{
            User userData = userRepository.findByUid(uid);
            user.put("uid", userData.getUid());
            user.put("password", userData.getPassword());
            user.put("email", userData.getEmail());
        } catch (Exception e) {
            user.put("uid", "ERROR");
            user.put("password", "ERROR");
            user.put("email", "ERROR");
        }

        return user;
    }
}
