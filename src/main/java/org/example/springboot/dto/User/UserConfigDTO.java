package org.example.springboot.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.User.User_Config;

@Getter
@ToString
@NoArgsConstructor
public class UserConfigDTO {
    private User user;
    private Boolean comment;

    public User_Config toEntity() {
        return User_Config.builder()
                .user(user)
                .comment(comment)
                .build();
    }

    @Builder
    public UserConfigDTO(User user, Boolean comment) {
        this.user = user;
        this.comment = comment;
    }
}
