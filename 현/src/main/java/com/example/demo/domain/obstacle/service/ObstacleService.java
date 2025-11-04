package com.example.demo.domain.obstacle.service;

import com.example.demo.domain.obstacle.dto.ObstacleRequestDto;
import com.example.demo.domain.obstacle.dto.ObstacleResponseDto;
import com.example.demo.domain.obstacle.entity.Obstacle;
import com.example.demo.domain.obstacle.repository.ObstacleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ObstacleService {

    private final ObstacleRepository obstacleRepository;
    private final UserRepository userRepository; // ✅ 추가

    public ObstacleResponseDto saveObstacle(ObstacleRequestDto dto) {
        // 1) 유저 엔티티 조회
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + dto.getUserId()));

        // 2) Obstacle 생성
        Obstacle obstacle = Obstacle.builder()
                .user(user)                                      // ✅ userId(...)가 아니라 user(...)
                .obstacleName(dto.getObstacleName())
                .lat(dto.getLat().floatValue())                  // 엔티티가 Float라면 형 변환
                .lon(dto.getLon().floatValue())
                .imageloc(dto.getImage())
                .created_at(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .updated_at(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .build();

        obstacleRepository.save(obstacle);

        return new ObstacleResponseDto("ok", "장애물 정보 수신 완료", obstacle);
    }
}

