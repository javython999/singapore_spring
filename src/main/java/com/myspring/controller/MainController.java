package com.myspring.controller;

import com.myspring.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

	private final BoardService boardService;

	// 인덱스 페이지
	@GetMapping(value = "/")
	public String index(Model model) throws Exception {

		model.addAttribute("boardList", boardService.findAll());
		//model.addAttribute("GardenStarAVG", GardenService.starAVG());
		//model.addAttribute("ChinaStarAVG", ChinaService.starAVG());
		//model.addAttribute("SentosaStarAVG", SentosaService.starAVG());
		log.info("index");
		return "index";
	}

}
