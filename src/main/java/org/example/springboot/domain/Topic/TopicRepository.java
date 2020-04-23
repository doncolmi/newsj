package org.example.springboot.domain.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(String name);
    List<Topic> findAll();

    @Query(value = "SELECT t.hi from (SELECT NAME, RANK() OVER(ORDER BY follow DESC) hi FROM topic) t WHERE t.name = :name", nativeQuery = true)
    int getRankByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE topic SET follow = follow - 1 WHERE name = :name", nativeQuery = true)
    void minusFollow(@Param("name") String name) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "UPDATE topic SET follow = follow + 1 WHERE name = :name", nativeQuery = true)
    void plusFollow(@Param("name") String name) throws Exception;
}
