package com.myspring.dao;

import com.myspring.vo.MemberVO;

public interface MemberDAO {
	
	public void insert(MemberVO memberVO);
	public String loginCheck(MemberVO memberVO);
}
