package org.example.springboot.domain.News;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsReplyRepository extends JpaRepository<NewsReply, Long> {
    int countByNews(News news);

    @Query(value = "select * from news_reply WHERE news_id = :id order by id DESC LIMIT :start,5", nativeQuery = true)
    List<NewsReply> getNewsReply(Long id, int start);
}
