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

    @Query(value = "SELECT * FROM news WHERE id = :o OR id = :t OR id = :th OR id = :f OR id = :fi", nativeQuery = true)
    ArrayList<News> getNewsListRnd(Long o, Long t, Long th, Long f, Long fi);

    @Query(value = "select * from news WHERE topic_id = :id order by id DESC LIMIT :start,10", nativeQuery = true)
    ArrayList<News> getTopicNews(Long id, int start);
}
