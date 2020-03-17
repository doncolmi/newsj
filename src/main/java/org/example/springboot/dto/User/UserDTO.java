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
    private String UID;
    private String PASSWORD;
    private String EMAIL;

    public User toEntity() {
        return User.builder()
                .UID(UID)
                .PASSWORD(PASSWORD)
                .EMAIL(EMAIL)
                .build();
    }

    @Builder
    public UserDTO(String UID, String PASSWORD, String EMAIL) {
        this.UID = UID;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
    }
}
