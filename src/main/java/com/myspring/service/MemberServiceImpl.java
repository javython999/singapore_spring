package com.myspring.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.myspring.dao.MemberDAO;
import com.myspring.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDAO;
	
	// 로그인 처리
	@Override
	public String loginCheck(MemberVO memberVO, HttpSession session) {
		//맞으면 닉네임이 넘어오고 틀리면 null이 넘어옴
		String nickname = memberDAO.loginCheck(memberVO);
		
		if(nickname != null) { // 맞으면
			// 세션등록
			session.setAttribute("user_nickname", nickname);
			session.setAttribute("user_id", memberVO.getId());
		}
		return nickname;
	}

	
	// 로그아웃 처리
	@Override
	public void logout(HttpSession session) {
		// 세션을 모두 초기화 시킴
		session.invalidate();
	}

}
