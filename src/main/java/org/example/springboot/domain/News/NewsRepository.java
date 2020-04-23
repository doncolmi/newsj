package org.example.springboot.domain.News;

import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface NewsRepository extends JpaRepository<News, Long> {
    long count();
    int countByHref(String href);
    int countByPress(Press press);
    int countByTopic(Topic topic);

    @Query(value = "select * from news WHERE press_id = :id order by id DESC LIMIT :start,10", nativeQuery = true)
    ArrayList<News> getPressNews(Long id,int start);

    @Query(value = "select * from news order by id desc limit :start,10", nativeQuery = true)
    ArrayList<News> getNewsList(int start);

    @Query(value = "SELECT * FROM news WHERE `created_date` >= DATE_ADD(NOW(), INTERVAL -3 DAY) ORDER BY RAND() LIMIT 5", nativeQuery = true)
    ArrayList<News> getNewsListRnd();

    @Query(value = "select * from news WHERE topic_id = :id order by id DESC LIMIT :start,10", nativeQuery = true)
    ArrayList<News> getTopicNews(Long id, int start);
}
