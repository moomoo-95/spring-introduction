package moomoo.spring.introduction.controller;

import moomoo.spring.introduction.domain.Member;
import moomoo.spring.introduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // 회원가입 화면
    @GetMapping("/members/new")
    public String createFrom() {
        return "members/createMemberForm";
    }
    // 회원가입 데이터
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        memberService.join(form.getName());
        return "redirect:/";
    }
    // 회원 목록 조회
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
