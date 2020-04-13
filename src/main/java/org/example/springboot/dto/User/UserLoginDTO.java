package org.example.springboot.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserLoginDTO {
    private String id;
    private String pw;

    @Builder
    public UserLoginDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
