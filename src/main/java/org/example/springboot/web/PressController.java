package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.dto.Press.PressDTO;
import org.example.springboot.service.PressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class PressController {
    private final PressService pressService;

    @PostMapping("/press")
    public Long savePress(@RequestBody PressDTO press) {
        return pressService.savePress(press);
    }

    @GetMapping("/press")
    public List<Press> getPressAll() {
        return pressService.getPressAll();
    }

    @GetMapping("/press/add")
    public Long addFavPress(@RequestParam("name") String name, @RequestParam("uid") String uid) { return pressService.addFavPress(name, uid); }

    @GetMapping("/press/remove")
    public void removeFavPress(@RequestParam("name") String name, @RequestParam("uid") String uid) { pressService.removeFavPress(name, uid); }

}
