package org.example.springboot.domain.UsersData;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.User.User;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "FAV_TOPIC")
public class Fav_Topic extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="USER_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name ="TOPIC_id", nullable = false)
    private Topic topic;

    @Builder
    public Fav_Topic(User user, Topic topic) {
        this.user = user;
        this.topic = topic;
    }
}
