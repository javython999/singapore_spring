package com.myspring.service;

import javax.servlet.http.HttpSession;

import com.myspring.vo.MemberVO;

public interface MemberService {
	public String loginCheck(MemberVO memberVO, HttpSession	session);
	public void logout(HttpSession session);
}
