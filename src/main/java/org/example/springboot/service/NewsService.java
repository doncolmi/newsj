package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.News.NewsRepository;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Press.PressRepository;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.Topic.TopicRepository;
import org.example.springboot.dto.News.NewsDTO;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Log4j2
@Service
@AllArgsConstructor
public class NewsService {
    private final PressRepository pressRepository;
    private final TopicRepository topicRepository;
    private final NewsRepository newsRepository;

    @Transactional
    public Long saveNews(JSONObject news) {
        Press press = pressRepository.findByName((String)news.get("press"));
        Topic topic = topicRepository.findById(((Number) news.get("topic")).longValue()).get();
        NewsDTO newsDTO =
                new NewsDTO(
                        press,
                        topic,
                        (String) news.get("title"),
                        (String) news.get("contents"),
                        (String) news.get("news_dt"),
                        (String) news.get("href")
                );
        return newsRepository.save(newsDTO.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public News getNews(Long id) {
        return newsRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    public int cntHref(String href) { return newsRepository.countByHref(href); }

    @Transactional
    public ArrayList<News> getNewsList(int page) {
        int start = 10 * page;
        return newsRepository.getNewsList(start);
    }
}

