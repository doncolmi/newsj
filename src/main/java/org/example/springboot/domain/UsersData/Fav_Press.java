package org.example.springboot.domain.UsersData;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.User.User;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "FAV_PRESS")
public class Fav_Press extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="USER_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name ="PRESS_name", nullable = false)
    private Press press;

    @Builder
    public Fav_Press(User user, Press press) {
        this.user = user;
        this.press = press;
    }
}
