package com.example.demo.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "socialuserinfo")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class SocialUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String puserid;

    @Column(nullable = false)
    private String email;
}
