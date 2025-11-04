package com.example.demo.domain.obstacle.service;

import com.example.demo.domain.obstacle.dto.ImageUploadResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class ImageService {

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/images";
    private static final String IMAGE_URL_PREFIX = "/images";

    public ImageUploadResponseDto saveImage(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어 있습니다.");
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String originalName = file.getOriginalFilename();
        String timestamp = LocalDateTime.now(ZoneId.of("Asia/Seoul"))
                .format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssSSS"));
        String savedName = timestamp + "_" + originalName;
        Path savePath = Paths.get(UPLOAD_DIR, savedName);

        try {
            file.transferTo(savePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생", e);
        }

        String relativePath = IMAGE_URL_PREFIX + "/" + savedName;
        return new ImageUploadResponseDto("ok", "이미지 업로드 성공", relativePath);
    }
}
