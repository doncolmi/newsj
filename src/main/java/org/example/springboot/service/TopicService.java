package org.example.springboot.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.News.NewsRepository;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.Topic.TopicRepository;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.User.UserRepository;
import org.example.springboot.domain.UsersData.FavTopicRepository;
import org.example.springboot.domain.UsersData.Fav_Topic;
import org.example.springboot.dto.Topic.TopicInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final FavTopicRepository favTopicRepository;

    @Transactional
    public TopicInfoDTO getTopic(String name) {
        try{
            Topic topic = topicRepository.findByName(name);
            int cntNews = newsRepository.countByTopic(topic);
            int rank = topicRepository.getRankByName(name);
            return new TopicInfoDTO(topic.getName(), topic.getFollow(), rank, cntNews);
        } catch (Exception e) {
            e.printStackTrace();
            return new TopicInfoDTO("ERROR", 0, 0, 0);
        }
    }

    @Transactional
    public List<Topic> getTopicAll() {
        return topicRepository.findAll();
    }

    @Transactional
    public ArrayList<News> getTopicNews(String name, int page) {
        int start = 10 * page;
        Long id = topicRepository.findByName(name).getId();
        return newsRepository.getTopicNews(id, start);
    }

    @Transactional
    public int cntByTopic(String name) {
        try{
            Topic topic = topicRepository.findByName(name);
            return newsRepository.countByTopic(topic);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Transactional
    public int[] getFollowMe(String id) {
        int[] result = new int[6];
        User user = userRepository.findByUid(id);
        for(Long i = 0L; i < 6L; i++) {
            int check = favTopicRepository.countByUserAndTopic(user, topicRepository.findById(i + 1).get());
            result[i.intValue()] = check;
        }
        return result;
    }

    @Transactional
    public Long addFavTopic(String name, String uid) {
        User user = userRepository.findByUid(uid);
        Topic topic = topicRepository.findByName(name);
        try{
            topicRepository.plusFollow(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return favTopicRepository.save(new Fav_Topic(user, topic)).getId();
    }
    
    @Transactional
    public void removeFavTopic(String name, String uid) {
        User user = userRepository.findByUid(uid);
        Topic topic = topicRepository.findByName(name);
        Long id = favTopicRepository.findByUserAndTopic(user, topic).getId();
        favTopicRepository.deleteById(id);
        try{
            topicRepository.minusFollow(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


