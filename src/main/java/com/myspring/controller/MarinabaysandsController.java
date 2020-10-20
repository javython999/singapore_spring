package com.myspring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.dao.MarinaDAO;
import com.myspring.dao.MarinaDAOImpl;
import com.myspring.vo.BoardVO;

@Controller
public class MarinabaysandsController {
	
	@Inject
	MarinaDAOImpl marinaDAO;
	
	// comment 추가
	@RequestMapping("board/marinabaysands/inset.do")
	public String insert(@ModelAttribute BoardVO boardVO) {
		marinaDAO.insert(boardVO);
		return "redirect:/board/marinabaysands#commentList";
	}
	
	// comment 삭제
	@RequestMapping("board/marinabaysands/delete.do")
	public String delete(@ModelAttribute BoardVO boardVO) {
		marinaDAO.delete(boardVO);
		return "redirect:/board/marinabaysands#commentList";
	}
	
	// comment 수정
	@RequestMapping("board/marinabaysands/update.do")
	public String update(@ModelAttribute BoardVO boardVO) {
		marinaDAO.update(boardVO);
		return "redirect:/board/marinabaysands#commentList";
	}
}
