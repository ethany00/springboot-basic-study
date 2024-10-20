package spring.spring_basic_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.spring_basic_study.service.MemberService;

@Controller
public class MemeberController {

    private final MemberService memberService;

    // 필드 주입방식 , setter 주입방식 ( 권장 x )
    // @Autowired private MemberService memberService;

    @Autowired
    public MemeberController(MemberService memberService) {
        // DI
        // 기본적으로 Component 스캔은 같은 패키지 단위 기준
        this.memberService = memberService;
    }

}
