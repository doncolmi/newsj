package org.example.springboot.domain.UsersData;

import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.net.ssl.SSLSession;
import java.util.List;

public interface FavTopicRepository extends JpaRepository<Fav_Topic, Long> {
    int countByUserAndTopic(User user, Topic topic);

    Fav_Topic findByUserAndTopic(User user, Topic topic);

    List<Fav_Topic> findAllByUser(User user);
}
