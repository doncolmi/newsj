package org.example.springboot.service.Press;

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

    public int savePress(String[][] presses) {
        int res = 0;
        for(int i = 0; i < presses.length; i++) {
            Long pressId = pressRepository.save(new PressDTO(presses[i][0], presses[i][1]).toEntity()).getId();
            if (pressId > 0L) {
                res++;
            } else {
                log.info(presses[i][0] + " 언론사를 추가하는데 실패했습니다.");
            }
        }
        return res;
    }

    public List<Press> getPressAll() {
        return pressRepository.findAll();
    }
}
