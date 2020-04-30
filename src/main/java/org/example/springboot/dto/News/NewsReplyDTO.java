package org.example.springboot.dto.News;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.News.NewsReply;
import org.example.springboot.domain.User.User;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
public class NewsReplyDTO {
    private News news;
    private User user;
    private String contents;

    public NewsReply toEntity() {
        return NewsReply.builder()
                .news(news)
                .user(user)
                .contents(contents)
                .build();
    }

    @Builder
    public NewsReplyDTO(News news, User user, String contents) {
        this.news = news;
        this.user = user;
        this.contents = contents;
    }
}
