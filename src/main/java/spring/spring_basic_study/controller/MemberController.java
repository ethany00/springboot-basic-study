package spring.spring_basic_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.spring_basic_study.domain.Member;
import spring.spring_basic_study.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 필드 주입방식 , setter 주입방식 ( 권장 x )
    // @Autowired private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        // DI
        // 기본적으로 Component 스캔은 같은 패키지 단위 기준
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member = " + member.getName());
        memberService.join(member);
        return "redirect:/";
    }

}
