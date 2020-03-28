package org.example.springboot.domain.News;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    int countByHref(String href);
}
