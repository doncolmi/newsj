package org.example.springboot.dto.Topic;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class TopicInfoDTO {
    private String name;
    private int follow;
    private int rank;
    private int newses;

    @Builder
    public TopicInfoDTO(String name, int follow, int rank, int newses) {
        this.name = name;
        this.follow = follow;
        this.rank = rank;
        this.newses = newses;
    }
}
