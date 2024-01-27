package com.myspring.controller;

import com.myspring.service.ChinaService;
import com.myspring.service.GardenService;
import com.myspring.service.MarinaService;
import com.myspring.service.SentosaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;

@Controller
@Slf4j
public class MainController {

	@Inject
	MarinaService MarinaService;
	
	@Inject
	GardenService GardenService;
	
	@Inject
	ChinaService ChinaService ;
	
	@Inject
	SentosaService SentosaService;
	

	// 인덱스 페이지
	@GetMapping(value = "/")
	public String index(Model model) throws Exception {
		//model.addAttribute("MarinaStarAVG", MarinaService.starAVG());
		//model.addAttribute("GardenStarAVG", GardenService.starAVG());
		//model.addAttribute("ChinaStarAVG", ChinaService.starAVG());
		//model.addAttribute("SentosaStarAVG", SentosaService.starAVG());
		log.info("index");
		return "index";
	}
	
	// 회원가입 페이지
	@GetMapping("/member/register")
	public String memberRegister() throws Exception {
		log.info("Member Register");
		return "member/register";
	}
	
	// 마리나베이샌즈 페이지
	@GetMapping("/board/marinabaysands")
	public String marinabaysands(Model model) throws Exception {
		log.info("Marina Bay Sands");
		//model.addAttribute("starAVG", MarinaService.starAVG());
		//model.addAttribute("list", MarinaService.list());
		model.addAttribute("boardName", "marinabaysands");
		return "board/marinabaysands";
	}
	
	// 가든스 바이 더베이 페이지
	@GetMapping("/board/gardensbythebay")
	public String gardensbythebay(Model model) throws Exception {
		log.info("Gardens By The bay");
		//model.addAttribute("starAVG", GardenService.starAVG());
		//model.addAttribute("list", GardenService.list());
		model.addAttribute("boardName", "gardensbythebay");
		return "board/gardensbythebay";
	}
	
	// 차이나 타운 페이지
	@GetMapping("/board/chinatown")
	public String chinatown(Model model) throws Exception {
		log.info("China Town");
		//model.addAttribute("starAVG", ChinaService.starAVG());
		//model.addAttribute("list", ChinaService.list());
		model.addAttribute("boardName", "chinatown");
		return "board/chinatown";
	}
	
	// 센토사 섬 페이지
	@GetMapping("/board/sentosa")
	public String sentosa(Model model) throws Exception {
		log.info("Sentosa Island");
		//model.addAttribute("starAVG", SentosaService.starAVG());
		//model.addAttribute("list", SentosaService.list());
		model.addAttribute("boardName", "sentosa");
		return "board/sentosa";
	}
	
	
}
