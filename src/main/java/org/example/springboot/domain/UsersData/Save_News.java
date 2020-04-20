package org.example.springboot.domain.UsersData;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.User.User;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "SAVE_NEWS")
public class Save_News extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="USER_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name ="NEWS_id", nullable = false)
    private News news;

    @Builder
    public Save_News(User user, News news) {
        this.user = user;
        this.news = news;
    }
}
