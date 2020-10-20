package com.myspring.dao;

import java.util.List;

import com.myspring.vo.BoardVO;


public interface MarinaDAO {
	public void insert(BoardVO boardVO);
	public void delete(BoardVO boardVO);
	public List<BoardVO> list() throws Exception;
	public void update(BoardVO boardVO);
	public double star();
}
