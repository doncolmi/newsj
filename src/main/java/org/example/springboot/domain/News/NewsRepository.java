package org.example.springboot.domain.News;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface NewsRepository extends JpaRepository<News, Long> {
    int countByHref(String href);

    @Query(value = "select * from news order by id desc limit :start,10", nativeQuery = true)
    ArrayList<News> getNewsList(int start);
}
