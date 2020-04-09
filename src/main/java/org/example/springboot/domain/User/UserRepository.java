package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUid(String uid);
    int countByUid(String uid);
    int countByEmail(String email);
}
