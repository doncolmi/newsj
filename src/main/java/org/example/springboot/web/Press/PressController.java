package org.example.springboot.web.Press;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.dto.Press.PressDTO;
import org.example.springboot.service.Press.PressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class PressController {
    private final PressService pressService;

//    @GetMapping("/press")
//    public Press getPress(@RequestParam String name) {
//        return pressService.getPress(name);
//    }

    @PostMapping("/press")
    public Long savePress(@RequestBody PressDTO press) {
        return pressService.savePress(press);
    }

    @GetMapping("/press/all")
    public List<Press> getPressAll() {
        return pressService.getPressAll();
    }

}
