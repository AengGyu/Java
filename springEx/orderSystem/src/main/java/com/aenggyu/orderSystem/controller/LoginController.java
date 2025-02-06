package com.aenggyu.orderSystem.controller;

import com.aenggyu.orderSystem.domain.Member;
import com.aenggyu.orderSystem.serevice.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;

    @GetMapping
    public String loginForm(@ModelAttribute Member member){
        return "login/loginForm";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute )
}
