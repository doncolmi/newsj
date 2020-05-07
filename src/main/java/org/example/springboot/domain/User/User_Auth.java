package org.example.springboot.domain.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.domain.Topic.Topic;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER_AUTH")
public class User_Auth extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="USER_id", nullable = true)
    private User user;

    @Column(length = 128, nullable = false)
    private String code;

    @Column(length = 128)
    @ColumnDefault("none")
    private String pwCode;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean admin;

    @Builder
    public User_Auth(User user, String code, Boolean admin,String pwCode) {
        this.user = user;
        this.code = code;
        this.admin = admin;
        this.pwCode = pwCode;
    }

    public void update(String pwCode) {
        this.pwCode = pwCode;
    }
}
