package org.example.springboot.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.dto.Topic.TopicInfoDTO;
import org.example.springboot.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping("/topic")
    public List<Topic> getTopicAll() {return topicService.getTopicAll();}

    @GetMapping("/topic/follow")
    public int[] getFollowMe(@RequestParam String id) {return topicService.getFollowMe(id);}

    @GetMapping("/topic/add")
    public Long addFavTopic(@RequestParam("name") String name, @RequestParam("uid") String uid) { return topicService.addFavTopic(name, uid); }

    @GetMapping("/topic/remove")
    public void removeFavTopic(@RequestParam("name") String name, @RequestParam("uid") String uid) { topicService.removeFavTopic(name, uid); }

    @GetMapping("/topic/{name}")
    public TopicInfoDTO getTopic(@PathVariable String name) {
        return topicService.getTopic(name);
    }

    @GetMapping("/topic/{name}/news")
    public ArrayList<News> getTopicNews(@PathVariable String name, @RequestParam int page) {
        return topicService.getTopicNews(name, page);
    }

    @GetMapping("/topic/{name}/cnt")
    public int cntByTopic(@PathVariable String name) {
        return topicService.cntByTopic(name);
    }

}
