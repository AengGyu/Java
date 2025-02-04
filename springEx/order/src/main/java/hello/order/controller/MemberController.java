package hello.order.controller;

import hello.order.domain.Grade;
import hello.order.domain.Member;
import hello.order.service.MemberService;
import hello.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final ProductService productService;

    @GetMapping("/new")
    public String createForm(){
        return "members/register";
    }

    @PostMapping("/new")
    public String create(@RequestParam String name, @RequestParam Grade grade){
        Member member = new Member(name, grade);
        memberService.join(member);
        return "redirect:/members";
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("members", memberService.findAllMembers());
        return "members/list";
    }

    @GetMapping("/products")
    public String productList(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products/customerList";
    }
}
