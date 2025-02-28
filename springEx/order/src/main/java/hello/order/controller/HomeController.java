package hello.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/admin-home")
    public String adminHome(){
        return "admin";
    }

    @GetMapping("/member-home")
    public String memberHome(){
        return "member";
    }
}
