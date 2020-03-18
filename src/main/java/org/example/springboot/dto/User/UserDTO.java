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
    private String uid;
    private String password;
    private String email;

    public User toEntity() {
        return User.builder()
                .uid(uid)
                .password(password)
                .email(email)
                .build();
    }

    @Builder
    public UserDTO(String uid, String password, String email) {
        this.uid = uid;
        this.password = password;
        this.email = email;
    }
}
