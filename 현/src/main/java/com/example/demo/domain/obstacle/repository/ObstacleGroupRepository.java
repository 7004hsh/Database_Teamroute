package com.example.demo.domain.obstacle.repository;

import com.example.demo.domain.obstacle.entity.ObstacleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObstacleGroupRepository extends JpaRepository<ObstacleGroup, Long> {
    // 커스텀 쿼리 예시:
    // ObstacleGroup findByObstacleGroupid(String obstaclegroupid);
}
