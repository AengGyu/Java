package com.aenggyu.orderSystem.controller;

import com.aenggyu.orderSystem.domain.member.Member;
import com.aenggyu.orderSystem.domain.member.MemberRegisterForm;
import com.aenggyu.orderSystem.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    //회원 가입 폼
    @GetMapping("/register")
    public String registerForm(@ModelAttribute("member") MemberRegisterForm form) {
        return "members/addMemberForm";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("member") MemberRegisterForm form,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

//        if(memberService.findMemberByLoginId(form.getLoginId()).isPresent()){
//            bindingResult.reject("loginId", "이미 사용 중인 아이디입니다.");
//
//            return "members/addMemberForm";
//        }

        if (memberService.findMemberByLoginId(form.getLoginId()).isPresent()) {
            bindingResult.rejectValue("loginId", "duplicateMember", "이미 사용 중인 아이디입니다.");
            return "members/addMemberForm";
        }

        Member newMember = new Member(form.getLoginId(), form.getPassword(), form.getName());

        Member savedMember = memberService.register(newMember);
        redirectAttributes.addAttribute("memberId", savedMember.getId());
        redirectAttributes.addAttribute("status", true);


        return "redirect:/members/{memberId}";
    }

    @GetMapping("/{id}")
    public String member(@PathVariable long id, Model model) {
        Member member = memberService.findMemberById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        model.addAttribute("member", member);
        return "members/member";
    }
}
