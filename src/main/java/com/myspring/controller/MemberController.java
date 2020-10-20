package com.myspring.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.dao.MemberDAO;
import com.myspring.service.MemberService;
import com.myspring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject
	MemberDAO memberDAO;
	@Inject
	MemberService memberService;
	
	
	// 회원가입
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberVO memberVO) {
		memberDAO.insert(memberVO);
		return "index";
	}
	
	
	// 로그인
	@RequestMapping("member/login_check.do")
	public String login_check(@ModelAttribute MemberVO memberVO, HttpSession session) {
		
		String nickname = memberService.loginCheck(memberVO, session);
		
		return "redirect:/";
	}
	
	// 로그아웃 (세션 삭제)
	@RequestMapping("member/logout.do")
	public String login_check(HttpSession session) {
		
		memberService.logout(session);

		return "redirect:/";
	}
	
	
	
	
}
