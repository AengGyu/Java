package com.aenggyu.orderSystem;

import com.aenggyu.orderSystem.domain.Grade;
import com.aenggyu.orderSystem.domain.member.Member;
import com.aenggyu.orderSystem.repository.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init(){
        Member admin = new Member();
        admin.setLoginId("admin");
        admin.setPassword("admin!");
        admin.setName("admin");
        admin.setGrade(Grade.ADMIN);
        memberRepository.save(admin);

        Member test = new Member();
        test.setLoginId("test");
        test.setPassword("test!");
        test.setName("test");
        test.setGrade(Grade.BRONZE);
        memberRepository.save(test);
    }
}
