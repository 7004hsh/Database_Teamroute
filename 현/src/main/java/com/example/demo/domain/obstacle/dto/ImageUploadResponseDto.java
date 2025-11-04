package com.example.demo.domain.obstacle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageUploadResponseDto {
    private String status;
    private String message;
    private String imagePath;
}
