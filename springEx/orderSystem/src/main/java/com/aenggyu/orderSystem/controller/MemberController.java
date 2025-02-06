package com.aenggyu.orderSystem.controller;

import com.aenggyu.orderSystem.domain.Grade;
import com.aenggyu.orderSystem.domain.member.Member;
import com.aenggyu.orderSystem.domain.member.MemberRegisterForm;
import com.aenggyu.orderSystem.serevice.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    //회원 가입 폼
    @GetMapping("/register")
    public String registerForm(@ModelAttribute Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("member") MemberRegisterForm form,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        Member newMember = new Member(form.getLoginId(), form.getPassword(), form.getName());

        Member savedMember = memberService.register(newMember);
        redirectAttributes.addAttribute("memberId", savedMember.getId());
        redirectAttributes.addAttribute("status", true);


        return "redirect:/members/{itemId}";
    }
}
