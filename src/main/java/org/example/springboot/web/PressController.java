package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.dto.Press.PressDTO;
import org.example.springboot.dto.Press.PressInfoDTO;
import org.example.springboot.service.PressService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/press/follow")
    public List<Press> getPressAllOrderByFollow() {
        return pressService.getPressAllOrderByFollow();
    }

    @GetMapping("/press/add")
    public Long addFavPress(@RequestParam("name") String name, @RequestParam("uid") String uid) { return pressService.addFavPress(name, uid); }

    @GetMapping("/press/remove")
    public void removeFavPress(@RequestParam("name") String name, @RequestParam("uid") String uid) { pressService.removeFavPress(name, uid); }

    @GetMapping("/press/{name}")
    public PressInfoDTO getPress(@PathVariable String name) {
        return pressService.getPress(name);
    }

    @GetMapping("/press/{name}/news")
    public ArrayList<News> getPressNews(@PathVariable String name, @RequestParam int page) {
        log.info("엥");
        return pressService.getPressNews(name, page);
    }

    @GetMapping("/press/{name}/cnt")
    public int cntByPress(@PathVariable String name) {
        return pressService.cntByPress(name);
    }
}
