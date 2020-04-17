package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserAuthRepository extends JpaRepository<User_Auth, Long> {
    User_Auth findByUser(User user);
    int countByCode(String code);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_auth SET code = '0' WHERE code = :code", nativeQuery = true)
    void codeSetZero(@Param("code") String code) throws Exception;
}
