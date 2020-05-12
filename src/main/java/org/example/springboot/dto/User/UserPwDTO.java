package org.example.springboot.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserPwDTO {
    private String pw;
    private String salt;
    private String email;

    @Builder
    public UserPwDTO(String pw, String salt, String email) {
        this.salt = salt;
        this.pw = pw;
        this.email = email;
    }
}
