package com.myspring.controller;

import com.myspring.board.domain.Board;
import com.myspring.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

	private final BoardService boardService;

	@GetMapping(value = "/")
	public String index(Model model) {

		List<Board> boardList = boardService.findAll();
		List<Double> starAvgList = new ArrayList<>();

		for (Board board : boardList) {
			starAvgList.add(boardService.getStarAvg(board.getId()));
		}

		model.addAttribute("boardList", boardList);
		model.addAttribute("starAvgList", starAvgList);
		return "main/main.main";
	}

}
