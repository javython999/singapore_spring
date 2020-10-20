package com.myspring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.dao.SentosaDAOImpl;
import com.myspring.vo.BoardVO;

@Controller
public class SentosaController {
	
	@Inject
	SentosaDAOImpl boardDAO;
	
	// comment 추가
	@RequestMapping("board/sentosa/inset.do")
	public String insert(@ModelAttribute BoardVO boardVO) {
		boardDAO.insert(boardVO);
		return "redirect:/board/sentosa#commentList";
	}
	
	// comment 삭제
	@RequestMapping("board/sentosa/delete.do")
	public String delete(@ModelAttribute BoardVO boardVO) {
		boardDAO.delete(boardVO);
		return "redirect:/board/sentosa#commentList";
	}
	
	// comment 수정
	@RequestMapping("board/sentosa/update.do")
	public String update(@ModelAttribute BoardVO boardVO) {
		boardDAO.update(boardVO);
		return "redirect:/board/sentosa#commentList";
	}
}
