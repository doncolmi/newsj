package org.example.springboot.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserPwMyPageDTO {
    private String pw;
    private String salt;
    private String id;

    @Builder
    public UserPwMyPageDTO(String pw, String salt, String id) {
        this.salt = salt;
        this.pw = pw;
        this.id = id;
    }
}
