package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.entity.SocialUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserInfoRepository extends JpaRepository<SocialUserInfo, Long> {
    // 커스텀 쿼리 예시:
    // SocialUserInfo findBysocialusesrid(String socialuserid);
}
