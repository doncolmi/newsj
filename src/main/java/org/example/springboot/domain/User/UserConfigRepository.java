package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfigRepository extends JpaRepository<User_Config, Long> {
}
