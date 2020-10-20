package com.myspring.service;

import java.util.List;


import com.myspring.vo.BoardVO;


public interface ChinaService {
	public List<BoardVO> list() throws Exception;
	public double starAVG() throws Exception;
}
