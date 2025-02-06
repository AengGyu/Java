package com.aenggyu.orderSystem.service.login;

import com.aenggyu.orderSystem.domain.member.Member;

import java.util.Optional;

public interface LoginService {

    Optional<Member> login(String loginId, String password);
}
