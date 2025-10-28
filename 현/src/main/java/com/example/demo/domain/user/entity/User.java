package com.example.demo.domain.user.entity;

import com.example.demo.domain.obstacle.entity.Obstacle;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String pw;

    private String name;

    @Column(unique = true)
    private String email;

    private Boolean emailpermission;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus userstatus;

    // 연관관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Obstacle> obstacles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SocialUserInfo> socialUserInfos;
}
