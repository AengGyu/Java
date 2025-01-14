package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
//    @GetMapping("") 으로 해도 됨
    public String home(){
        return "home";
    }
}
