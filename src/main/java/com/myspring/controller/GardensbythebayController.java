package com.myspring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.dao.GardenDAOImp;
import com.myspring.dao.MarinaDAO;
import com.myspring.dao.MarinaDAOImpl;
import com.myspring.vo.BoardVO;

@Controller
public class GardensbythebayController {
	
	@Inject
	GardenDAOImp GardenDAO;
	
	// comment 추가
	@RequestMapping("board/gardensbythebay/inset.do")
	public String insert(@ModelAttribute BoardVO boardVO) {
		GardenDAO.insert(boardVO);
		return "redirect:/board/gardensbythebay#commentList";
	}
	
	// comment 삭제
	@RequestMapping("board/gardensbythebay/delete.do")
	public String delete(@ModelAttribute BoardVO boardVO) {
		GardenDAO.delete(boardVO);
		return "redirect:/board/gardensbythebay#commentList";
	}
	
	// comment 수정
	@RequestMapping("board/gardensbythebay/update.do")
	public String update(@ModelAttribute BoardVO boardVO) {
		GardenDAO.update(boardVO);
		return "redirect:/board/gardensbythebay#commentList";
	}
}
