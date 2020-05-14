package org.example.springboot.dto.News;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.News.News;
import org.example.springboot.domain.Press.Press;
import org.example.springboot.domain.Topic.Topic;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.UsersData.Save_News;

@Getter
@ToString
@NoArgsConstructor
public class SaveNewsDTO {
    private String userId;
    private Long newsId;

    @Builder
    public SaveNewsDTO(String userId, Long newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }
}
