package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Press.PressRepository;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.User.UserRepository;
import org.example.springboot.domain.UsersData.FavPressRepository;
import org.example.springboot.domain.UsersData.Fav_Press;
import org.example.springboot.dto.Press.PressDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class PressService {
    private final UserRepository userRepository;
    private final PressRepository pressRepository;
    private final FavPressRepository favPressRepository;

    @Transactional
    public Long savePress(PressDTO press) {
        return pressRepository.save(press.toEntity()).getId();
    }

    @Transactional
    public List<Press> getPressAll() {
        return pressRepository.findAllByOrderByNameAsc();
    }

    @Transactional
    public Long addFavPress(String name, String uid) {
        User user = userRepository.findByUid(uid);
        Press press = pressRepository.findByName(name);
        return favPressRepository.save(new Fav_Press(user, press)).getId();
    }

    @Transactional
    public void removeFavPress(String name, String uid) {
        User user = userRepository.findByUid(uid);
        Press press =pressRepository.findByName(name);
        Long id = favPressRepository.findByUserAndPress(user, press).getId();
        favPressRepository.deleteById(id);
    }
}
