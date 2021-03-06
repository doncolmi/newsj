package org.example.springboot.domain.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.dto.User.UserPwDTO;
import org.example.springboot.dto.User.UserPwMyPageDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false, unique = true)
    private String uid;

    @Column(length = 512, nullable = false)
    private String password;

    @Column(length = 512, nullable = false, unique = true)
    private String email;

    @Column(length = 512, nullable = false)
    private String salt;

    @Builder
    public User(String uid, String password, String email, String salt) {
        this.uid = uid;
        this.password = password;
        this.email = email;
        this.salt = salt;
    }

    public void update(UserPwDTO userPwDTO) {
        this.password = userPwDTO.getPw();
        this.salt = userPwDTO.getSalt();
    }

    public void update(UserPwMyPageDTO userPwMyPageDTO) {
        this.password = userPwMyPageDTO.getPw();
        this.salt = userPwMyPageDTO.getSalt();
    }
}
