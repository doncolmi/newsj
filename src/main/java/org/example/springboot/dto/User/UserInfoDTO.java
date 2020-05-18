package org.example.springboot.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class UserInfoDTO {
    private String id;
    private String email;

    @Builder
    public UserInfoDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
