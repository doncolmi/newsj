package org.example.springboot.domain.UsersData;

import org.example.springboot.domain.News.News;
import org.example.springboot.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaveNewsRepository extends JpaRepository<Save_News, Long> {
    int countByUserAndNews(User user, News news);

    Save_News findByUserAndNews(User user, News news);

    Long countByUser(User user);

    @Query(value = "select * from save_news WHERE user_id = :user order by id DESC LIMIT :start,10", nativeQuery = true)
    List<Save_News> getSaveNewsList(int start, Long user);
}
