package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.service.NewsService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@AllArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/news/{id}")
    public News getNews(@PathVariable Long id) {
        return newsService.getNews(id);
    }

    @PostMapping("/news")
    public Long saveNews(@RequestBody JSONObject news) {
        return newsService.saveNews(news);
    }

    @GetMapping("/news")
    public int cntHref(@RequestParam String href){ return newsService.cntHref(href); }
}
