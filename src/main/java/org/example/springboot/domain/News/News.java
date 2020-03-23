package org.example.springboot.domain.News;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Topic.Topic;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "NEWS")
public class News extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="PRESS_id", nullable = true)
    private Press press;

    @ManyToOne
    @JoinColumn(name ="TOPIC_id", nullable = true)
    private Topic topic;

    @Column(length = 200, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String contents;

    @Column(length = 100, nullable = false)
    private String news_dt;

    @Column(length = 500, nullable = true)
    private String img;

    @Builder
    public News(Press press, Topic topic, String title, String contents, String news_dt, String img) {
        this.press = press;
        this.topic = topic;
        this.title = title;
        this.contents = contents;
        this.news_dt = news_dt;
        this.img = img;
    }
}
