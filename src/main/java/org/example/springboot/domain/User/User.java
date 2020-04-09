package org.example.springboot.domain.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

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

    @Builder
    public User(String uid, String password, String email) {
        this.uid = uid;
        this.password = password;
        this.email = email;
    }
}
