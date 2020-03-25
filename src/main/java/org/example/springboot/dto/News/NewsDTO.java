package org.example.springboot.dto.News;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Topic.Topic;

@Getter
@ToString
@NoArgsConstructor
public class NewsDTO {
    private Press press;
    private Topic topic;
    private String title;
    private String contents;
    private String news_dt;
    private String img;
    private String href;

    public News toEntity() {
        return News.builder()
                .press(press)
                .topic(topic)
                .title(title)
                .contents(contents)
                .news_dt(news_dt)
                .img(img)
                .href(href)
                .build();
    }

    @Builder
    public NewsDTO(Press press, Topic topic, String title, String contents, String news_dt, String img, String href) {
        this.press = press;
        this.topic = topic;
        this.title = title;
        this.contents = contents;
        this.news_dt = news_dt;
        this.img = img;
        this.href = href;
    }
}
