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
    private Long ID;

    @Column(length = 45, nullable = false)
    private String UID;

    @Column(length = 512, nullable = false)
    private String PASSWORD;

    @Column(length = 512, nullable = false)
    private String EMAIL;

    @Builder
    public User(String UID, String PASSWORD, String EMAIL) {
        this.UID = UID;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
    }
}
