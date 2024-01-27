package com.myspring.member.controller;

import com.myspring.member.domain.Member;
import com.myspring.member.domain.MemberRequestDto;
import com.myspring.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String memberRegister() {
        log.info("Member Register");
        return "member/register";
    }

    @PostMapping("/member/insert")
    public String insert(MemberRequestDto memberRequestDto) {

        Member member = Member.builder()
                .loginId(memberRequestDto.getLoginId())
                .loginPw(memberRequestDto.getLoginPw())
                .nickname(memberRequestDto.getNickname())
                .regDateTime(LocalDateTime.now())
                .build();

        memberService.save(member);

        return "index";
    }

    @PostMapping("/member/login")
    public String loginCheck(MemberRequestDto memberRequestDto, HttpSession session) {
        Member findMember = memberService.loginCheck(memberRequestDto.getLoginId(), memberRequestDto.getLoginPw());

        if(findMember != null) {
            session.setAttribute("user_nickname", findMember.getNickname());
            session.setAttribute("user_id", findMember.getLoginId());
        }

        return "redirect:/";
    }

    @GetMapping("/member/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
