package org.example.springboot.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.User.User;

@Getter
@ToString
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String pw;
    private String email;
    private String salt;

    public User toEntity() {
        return User.builder()
                .uid(id)
                .password(pw)
                .email(email)
                .salt(salt)
                .build();
    }

    @Builder
    public UserDTO(String id, String pw, String email, String salt) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.salt = salt;
    }
}
