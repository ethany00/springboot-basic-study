package spring.spring_basic_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // static 가기전 controller view먼저 검색
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
