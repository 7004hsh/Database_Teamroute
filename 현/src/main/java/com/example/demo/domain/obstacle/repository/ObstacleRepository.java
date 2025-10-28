package com.example.demo.domain.obstacle.repository;

import com.example.demo.domain.obstacle.entity.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {
    // 커스텀 쿼리 예시:
    // Obstacle findByObstacleid(String obstacleid);
}
