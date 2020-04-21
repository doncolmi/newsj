package org.example.springboot.domain.News;

import org.example.springboot.domain.Press.Press;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface NewsRepository extends JpaRepository<News, Long> {
    long count();
    int countByHref(String href);
    int countByPress(Press press);

    @Query(value = "select * from news order by id desc limit :start,10", nativeQuery = true)
    ArrayList<News> getNewsList(int start);

    @Query(value = "SELECT * FROM news WHERE `created_date` >= DATE_ADD(NOW(), INTERVAL -3 DAY) ORDER BY RAND() LIMIT 5", nativeQuery = true)
    ArrayList<News> getNewsListRnd();
}
