package org.example.springboot.domain.Press;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PressRepository extends JpaRepository<Press, Long> {
    Press findByName(String name);
    List<Press> findAllByOrderByNameAsc();
}
