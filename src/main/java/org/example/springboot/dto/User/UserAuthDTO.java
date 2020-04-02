package org.example.springboot.dto.User;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.User.User;
import org.example.springboot.domain.User.User_Auth;

@Getter
@ToString
@NoArgsConstructor
public class UserAuthDTO {
    private User user;
    private String code;
    private Boolean admin;

    public User_Auth toEntity() {
        return User_Auth.builder()
                .user(user)
                .code(code)
                .admin(admin)
                .build();
    }

    @Builder
    public UserAuthDTO(User user, String code, Boolean admin) {
        this.user = user;
        this.code = code;
        this.admin = admin;
    }
}
