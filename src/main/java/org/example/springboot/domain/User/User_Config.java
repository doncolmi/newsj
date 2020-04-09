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
@Table(name = "USER_CONFIG")
public class User_Config extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="USER_id", nullable = true)
    private User user;

    @Column(nullable = false)
    private Boolean comment;

    @Builder
    public User_Config(User user, Boolean comment) {
        this.user = user;
        this.comment = comment;
    }
}
