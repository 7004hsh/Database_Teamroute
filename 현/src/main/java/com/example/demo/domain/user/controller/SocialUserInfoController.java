package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.entity.SocialUserInfo;
import com.example.demo.domain.user.repository.SocialUserInfoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socialuserinfo")
public class SocialUserInfoController {

    private final SocialUserInfoRepository socialUserInfoRepository;

    public SocialUserInfoController(SocialUserInfoRepository socialUserInfoRepository) {
        this.socialUserInfoRepository = socialUserInfoRepository;
    }

    // ✅ 전체 소셜 유저 정보 조회
    @GetMapping
    public List<SocialUserInfo> getAllSocialUsers() {
        return socialUserInfoRepository.findAll();
    }

    // ✅ 특정 ID로 조회
    @GetMapping("/{id}")
    public SocialUserInfo getSocialUserById(@PathVariable Long id) {
        return socialUserInfoRepository.findById(id).orElse(null);
    }

    // ✅ 새 소셜 계정 등록
    @PostMapping
    public SocialUserInfo createSocialUser(@RequestBody SocialUserInfo socialUserInfo) {
        return socialUserInfoRepository.save(socialUserInfo);
    }

    // ✅ 정보 수정
    @PutMapping("/{id}")
    public SocialUserInfo updateSocialUser(@PathVariable Long id, @RequestBody SocialUserInfo updatedInfo) {
        return socialUserInfoRepository.findById(id)
                .map(info -> {
                    info.setProvider(updatedInfo.getProvider());
                    info.setPuserid(updatedInfo.getPuserid());
                    info.setEmail(updatedInfo.getEmail());
                    return socialUserInfoRepository.save(info);
                })
                .orElseGet(() -> {
                    updatedInfo.setId(id);
                    return socialUserInfoRepository.save(updatedInfo);
                });
    }

    // ✅ 삭제
    @DeleteMapping("/{id}")
    public void deleteSocialUser(@PathVariable Long id) {
        socialUserInfoRepository.deleteById(id);
    }
}
