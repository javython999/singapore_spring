package com.myspring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.vo.BoardVO;

@Repository
public class SentosaDAOImpl implements SentosaDAO {
		
		// 마이바티스 호출
		@Inject
		private SqlSession sqlSession;
		
		// comment 작성
		@Override
		public void insert(BoardVO boardVO) {
			sqlSession.insert("sentosaMapper.insert", boardVO);
		}

		@Override
		public void delete(BoardVO boardVO) {
			sqlSession.delete("sentosaMapper.delete", boardVO);

		}
		
		// comment List 조회
		@Override
		public List<BoardVO> list() throws Exception {
			
			return sqlSession.selectList("sentosaMapper.select");
		}

		// comment 수정
		@Override
		public void update(BoardVO boardVO) {
			sqlSession.delete("sentosaMapper.update", boardVO);
		}

		// 별점 평균
		@Override
		public double star() {
			return sqlSession.selectOne("sentosaMapper.starAVG"); 
		}
}
