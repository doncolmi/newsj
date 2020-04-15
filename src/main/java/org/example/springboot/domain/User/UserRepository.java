package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUid(String uid);
    User findByEmail(String email);
    int countByUid(String uid);
    int countByEmail(String email);
    int countByUidAndPassword(String uid, String pw);
}
