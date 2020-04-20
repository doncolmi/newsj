package org.example.springboot.domain.UsersData;

import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavPressRepository extends JpaRepository<Fav_Press, Long> {
    int countByUser(User user);
    List<Fav_Press> findAllByUser(User user);
    Fav_Press findByUserAndPress(User user, Press press);
}
