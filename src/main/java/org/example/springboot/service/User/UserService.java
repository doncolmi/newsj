package org.example.springboot.service.User;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.User.UserRepository;
import org.example.springboot.dto.User.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDTO userDTO) {
        return userRepository.save(userDTO.toEntity()).getID();
    }
}
