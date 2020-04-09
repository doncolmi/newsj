package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.*;
import org.example.springboot.dto.User.UserAuthDTO;
import org.example.springboot.dto.User.UserConfigDTO;
import org.example.springboot.dto.User.UserDTO;
import org.example.springboot.util.UtilSet;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.example.springboot.util.UtilSet.getRandomCode;

@Log4j2
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserAuthRepository userAuthRepository;
    private UserConfigRepository userConfigRepository;

    @Transactional
    public Long saveUser(UserDTO userDTO) {
        User user;
        try{
            user = userRepository.save(userDTO.toEntity());
            userAuthRepository.save(new UserAuthDTO(user, getRandomCode(20), false).toEntity());
            userConfigRepository.save(new UserConfigDTO(user, true).toEntity());
        } catch(Exception e) {
            e.printStackTrace();
            return 0L;
        }
        return user.getId();
    }

    @Transactional
    public User getUser(String uid) { return userRepository.findByUid(uid); }
    
}
