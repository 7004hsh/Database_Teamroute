package com.example.demo.domain.obstacle.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "obstaclegroup")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ObstacleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ObstacleState state;

    @OneToMany(mappedBy = "obstacleGroup", cascade = CascadeType.ALL)
    private List<Obstacle> obstacles;
}
