package com.myspring.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.vo.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	//마이바티스 호출
	@Inject
	private SqlSession sqlSession;
	
		
	@Override
	public void insert(MemberVO memberVO) {
		sqlSession.insert("memberMapper.insert", memberVO);
		
	}


	@Override
	public String loginCheck(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.login_check", memberVO); 
	}

}
