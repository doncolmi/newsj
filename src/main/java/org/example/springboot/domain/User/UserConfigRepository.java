package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserConfigRepository extends JpaRepository<User_Config, Long> {
    User_Config findByUser(User user);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_config SET comment = :b WHERE user_id = :id", nativeQuery = true)
    void setComment(Long id, boolean b);
}
