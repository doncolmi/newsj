package org.example.springboot.dto.News;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewsReplyUpdateDTO {
    private String contents;

    @Builder
    public NewsReplyUpdateDTO(String contents) {
        this.contents = contents;
    }
}