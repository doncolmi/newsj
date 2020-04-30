package org.example.springboot.domain.News;

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
@Table(name = "NEWS_REPLY")
public class NewsReply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="NEWS_id", nullable = false)
    private News news;

    @ManyToOne
    @JoinColumn(name ="USER_id", nullable = false)
    private User user;

    @Lob
    @Column(nullable = false)
    private String contents;

    @Builder
    public NewsReply(News news, User user, String contents) {
        this.news = news;
        this.user = user;
        this.contents = contents;
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
