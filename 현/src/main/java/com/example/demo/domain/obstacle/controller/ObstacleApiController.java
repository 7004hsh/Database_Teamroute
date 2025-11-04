package com.example.demo.domain.obstacle.controller;

import com.example.demo.domain.obstacle.dto.ImageUploadResponseDto;
import com.example.demo.domain.obstacle.dto.ObstacleRequestDto;
import com.example.demo.domain.obstacle.dto.ObstacleResponseDto;
import com.example.demo.domain.obstacle.service.ImageService;
import com.example.demo.domain.obstacle.service.ObstacleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ObstacleApiController {

    private final ImageService imageService;
    private final ObstacleService obstacleService;

    // ✅ 이미지 업로드
    @PostMapping("/upload-image")
    public ResponseEntity<ImageUploadResponseDto> uploadImage(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(imageService.saveImage(file));
    }

    // ✅ 장애물 등록
    @PostMapping("/obstacles")
    public ResponseEntity<ObstacleResponseDto> createObstacle(@RequestBody ObstacleRequestDto dto) {
        return ResponseEntity.ok(obstacleService.saveObstacle(dto));
    }

    // ✅ 장애물 목록 조회
    @GetMapping("/obstacles")
    public ResponseEntity<?> listObstacles() {
        return ResponseEntity.ok(obstacleService.getAllObstacles());
    }
}
