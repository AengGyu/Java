package com.aenggyu.orderSystem.controller;

import com.aenggyu.orderSystem.domain.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String home(){
//        return "index";
//    }

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Member loginMember = (Member) session.getAttribute("loginMember");

            if(loginMember != null){
                model.addAttribute("member", loginMember);
                return "home-login";
            }
        }

        return "index";
    }
}
