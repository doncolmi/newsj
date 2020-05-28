package org.example.springboot.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.News.NewsReply;
import org.example.springboot.dto.News.NewsReplyDTO;
import org.example.springboot.dto.News.NewsReplyUpdateDTO;
import org.example.springboot.dto.News.SaveNewsDTO;
import org.example.springboot.service.NewsService;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/news/chk")
    public int cntHref(@RequestParam String href){ return newsService.cntHref(href); }

    @GetMapping("/news")
    public ArrayList<News> getNewsList(@RequestParam int page){
        return newsService.getNewsList(page);
    }

    @GetMapping("/news/save/get")
    public ArrayList<News> getSaveNews(@RequestParam("page") int page, @RequestParam("id") String id){
        return newsService.getSaveNewsList(page, id);
    }

    @GetMapping("/news/recent")
    public ArrayList<News> getNewsRecent(@RequestParam("o") Long o,@RequestParam("t") Long t,@RequestParam("th") Long th,@RequestParam("f") Long f,@RequestParam("fi") Long fi) {
        return newsService.getNewsRecent(o, t, th, f, fi);
    }

    @GetMapping("/news/cnt")
    public Long getNewsCnt() {
        return newsService.getNewsCnt();
    }

    @GetMapping("/news/save/cnt")
    public int getSaveNewsCnt(@RequestParam String id) {
        return newsService.getSaveNewsCnt(id);
    }

    @GetMapping("/news/save/chk")
    public Long checkSave(@RequestParam("uId") String userId, @RequestParam("nId") Long newsId) {
        return newsService.checkSave(userId, newsId);
    }
    @DeleteMapping("/news/save/{id}")
    public Long deleteSave(@PathVariable Long id) {
        return newsService.deleteSave(id);
    }

    @PostMapping("/news/save")
    public Long checkSave(@RequestBody SaveNewsDTO saveNewsDTO) throws Exception {
        return newsService.saveUserNews(saveNewsDTO);
    }

    // this id : news_id
    @GetMapping("/news/{id}/reply")
    public List<NewsReply> getNewsReply(@PathVariable Long id, @RequestParam int page) { return newsService.getNewsReply(id, page); }

    // this id : news_id
    @GetMapping("/news/{id}/reply/cnt")
    public int getNewsReplyCnt(@PathVariable Long id) {
        return newsService.getNewsReplyCnt(id);
    }
    // this id : news_id
    @PostMapping("/news/{id}/reply")
    public Long saveNewsReply(@PathVariable Long id, @RequestBody JSONObject jsonObject) { return newsService.saveNewsReply(id, jsonObject); }

    // this id : news_reply_id
    @GetMapping("/news/reply/{id}")
    public NewsReply getNewsReplyForModify(@PathVariable Long id) { return newsService.getNewsReplyForModify(id); }

    // this id : news_reply_id
    @PatchMapping("/news/reply/{id}")
    public Long updateNewsReply(@PathVariable Long id, @RequestBody NewsReplyUpdateDTO newsReplyUpdateDTO) { return newsService.updateNewsReply(id, newsReplyUpdateDTO); }

    // this id : news_reply_id
    @DeleteMapping("/news/reply/{id}")
    public void deleteNewsReply(@PathVariable Long id) { newsService.deleteNewsReply(id); }

}
