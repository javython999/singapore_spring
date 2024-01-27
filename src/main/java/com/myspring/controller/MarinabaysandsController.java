package com.myspring.controller;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.BoardType;
import com.myspring.board.domain.CommentRequestDto;
import com.myspring.board.service.BoardService;
import com.myspring.board.service.CommentService;
import com.myspring.dao.MarinaDAOImpl;
import com.myspring.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequiredArgsConstructor
public class MarinabaysandsController {

	private final CommentService commentService;
	private final BoardService boardService;

	@Inject
	MarinaDAOImpl marinaDAO;
	
	// comment 추가
	@RequestMapping("board/marinabaysands/inset.do")
	public String insert(CommentRequestDto commentReqeustDto) {
		Board board = boardService.findByType(BoardType.MARINA_BAY_SANDS);


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
