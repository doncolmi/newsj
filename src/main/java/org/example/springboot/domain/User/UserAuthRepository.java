package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<User_Auth, Long> {
}
