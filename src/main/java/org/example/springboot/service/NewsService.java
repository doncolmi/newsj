package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.News.NewsRepository;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Press.PressRepository;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.Topic.TopicRepository;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.User.UserRepository;
import org.example.springboot.domain.UsersData.FavPressRepository;
import org.example.springboot.domain.UsersData.FavTopicRepository;
import org.example.springboot.domain.UsersData.Fav_Press;
import org.example.springboot.domain.UsersData.Fav_Topic;
import org.example.springboot.dto.News.NewsDTO;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class NewsService {
    private final PressRepository pressRepository;
    private final TopicRepository topicRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final FavPressRepository favPressRepository;
    private final FavTopicRepository favTopicRepository;

    @PersistenceContext
    private EntityManager em;

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

    @Transactional
    public ArrayList<News> getNewsRecent() {
        return newsRepository.getNewsListRnd();
    }

    @Transactional
    public Long getNewsCnt() {
        return newsRepository.count();
    }

    @Transactional
    public int cntNewsByPress(String id) {
        User user = userRepository.findByUid(id);
        List<Fav_Press> pressList = favPressRepository.findAllByUser(user);
        if (pressList.size() > 0) {
            ArrayList<Long> pressIdList = new ArrayList<>();
            for(int i = 0; i < pressList.size(); i++) {
                pressIdList.add(pressList.get(i).getPress().getId());
            }
            String sql = "select * from news where press_id = " + pressIdList.get(0).toString();
            for(int i = 1; i < pressIdList.size(); i++) {
                sql += " OR press_id = " + pressIdList.get(i).toString();
            }
            return cntNewsByPressSqlInt(em,sql).size();
        } else {
            return 0;
        }
    }

    @Transactional
    public List<News> cntNewsByPressSqlInt(EntityManager em, String que) {
        Query query = em.createNativeQuery(que, News.class);
        return query.getResultList();
    }

    @Transactional
    public List<News> getMyNewsByPress(String id, int page) {
        String pages =  Integer.toString(page * 10);
        User user = userRepository.findByUid(id);
        List<Fav_Press> pressList = favPressRepository.findAllByUser(user);
        String sql = "select * from news where press_id = " + pressList.get(0).getPress().getId().toString();
        for(int i = 1; i < pressList.size(); i++) {
            sql += " OR press_id = " + pressList.get(i).getPress().getId().toString();
        }
        sql += " order by id DESC LIMIT " + pages + ",10";
        return cntNewsByPressSqlInt(em,sql);
    }

    @Transactional
    public int cntNewsByTopic(String id) {
        User user = userRepository.findByUid(id);
        List<Fav_Topic> topicList = favTopicRepository.findAllByUser(user);
        if (topicList.size() > 0) {
            ArrayList<Long> topicIdList = new ArrayList<>();
            for(int i = 0; i < topicList.size(); i++) {
                topicIdList.add(topicList.get(i).getTopic().getId());
            }
            String sql = "select * from news where topic_id = " + topicIdList.get(0).toString();
            for(int i = 1; i < topicIdList.size(); i++) {
                sql += " OR topic_id = " + topicIdList.get(i).toString();
            }
            return cntNewsByPressSqlInt(em,sql).size();
        } else {
            return 0;
        }
    }

    @Transactional
    public List<News> getMyNewsByTopic(String id, int page) {
        String pages =  Integer.toString(page * 10);
        User user = userRepository.findByUid(id);
        List<Fav_Topic> topicList = favTopicRepository.findAllByUser(user);
        String sql = "select * from news where topic_id = " + topicList.get(0).getTopic().getId().toString();
        for(int i = 1; i < topicList.size(); i++) {
            sql += " OR topic_id = " + topicList.get(i).getTopic().getId().toString();
        }
        sql += " order by id DESC LIMIT " + pages + ",10";
        return cntNewsByPressSqlInt(em,sql);
    }
}

