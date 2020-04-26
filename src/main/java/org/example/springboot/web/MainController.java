package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class MainController {
    private final NewsService newsService;
    @GetMapping("/cnt/press")
    public int cntPress(@RequestParam String id) {
        return newsService.cntNewsByPress(id);
    }

    @GetMapping("/cnt/topic")
    public int cntTopic(@RequestParam String id) {
        return newsService.cntNewsByTopic(id);
    }


    @GetMapping("/main/press")
    public List<News> getMyNewsByPress(@RequestParam("id") String id, @RequestParam("page") int page) {
        return newsService.getMyNewsByPress(id, page);
    }

    @GetMapping("/main/topic")
    public List<News> getMyNewsByTopic(@RequestParam("id") String id, @RequestParam("page") int page) {
        return newsService.getMyNewsByTopic(id, page);
    }
}
