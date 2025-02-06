package com.aenggyu.orderSystem.serevice;

import com.aenggyu.orderSystem.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member register(Member member);
    Optional<Member> findMemberById(Long id);
    Optional<Member> findMemberByLoginId(String loginId);
    List<Member> findAllMembers();
}
