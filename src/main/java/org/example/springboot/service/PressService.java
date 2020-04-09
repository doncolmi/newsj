package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Press.PressRepository;
import org.example.springboot.dto.Press.PressDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class PressService {
    private final PressRepository pressRepository;

    public Long savePress(PressDTO press) {
        return pressRepository.save(press.toEntity()).getId();
    }

    public List<Press> getPressAll() {
        return pressRepository.findAll();
    }
}
