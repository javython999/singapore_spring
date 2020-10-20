package com.myspring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myspring.dao.ChinaDAO;
import com.myspring.vo.BoardVO;

@Service
public class ChinaServiceImpl implements ChinaService {

	@Inject
	private ChinaDAO boardDAO;
	
	
	// commentList 조회
	@Override
	public List<BoardVO> list() throws Exception {
		return boardDAO.list();
	}
	
	// 별점 평균 조회
	@Override
	public double starAVG() throws Exception {
		return boardDAO.star();
	}
}
