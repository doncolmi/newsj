package org.example.springboot.domain.Press;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PressRepository extends JpaRepository<Press, Long> {
    Press findByName(String name);
    List<Press> findAllByOrderByNameAsc();
    List<Press> findAllByOrderByFollowDesc();

    @Query(value = "SELECT t.hi from (SELECT NAME, RANK() OVER(ORDER BY follow DESC) hi FROM press) t WHERE t.name = :name", nativeQuery = true)
    int getRankByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE press SET follow = follow - 1 WHERE name = :name", nativeQuery = true)
    void minusFollow(@Param("name") String name) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "UPDATE press SET follow = follow + 1 WHERE name = :name", nativeQuery = true)
    void plusFollow(@Param("name") String name) throws Exception;
}
