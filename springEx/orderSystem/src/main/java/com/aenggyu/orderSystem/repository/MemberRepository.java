package com.aenggyu.orderSystem.repository;

import com.aenggyu.orderSystem.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // ID로 회원 찾기
    Optional<Member> findByLoginId(String loginId); // 로그인 ID로 회원 찾기
    List<Member> findAll(); // 모든 회원 조회 (ADMIN)
}
