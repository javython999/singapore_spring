package com.myspring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.service.ChinaService;
import com.myspring.service.GardenService;
import com.myspring.service.MarinaService;
import com.myspring.service.SentosaService;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	@Inject
	MarinaService MarinaService;
	
	@Inject
	GardenService GardenService;
	
	@Inject
	ChinaService ChinaService ;
	
	@Inject
	SentosaService SentosaService;
	
	
	// 인덱스 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws Exception {
		model.addAttribute("MarinaStarAVG", MarinaService.starAVG());
		model.addAttribute("GardenStarAVG", GardenService.starAVG());
		model.addAttribute("ChinaStarAVG", ChinaService.starAVG());
		model.addAttribute("SentosaStarAVG", SentosaService.starAVG());
		logger.info("index");
		return "index";
	}
	
	// 회원가입 페이지
	@RequestMapping("/member/register")
	public String memberRegister() throws Exception {
		logger.info("Member Register");
		return "member/register";
	}
	
	// 마리나베이샌즈 페이지
	@RequestMapping("/board/marinabaysands")
	public String marinabaysands(Model model) throws Exception {
		logger.info("Marina Bay Sands");
		model.addAttribute("starAVG", MarinaService.starAVG());
		model.addAttribute("list", MarinaService.list());
		model.addAttribute("boardName", "marinabaysands");
		return "board/marinabaysands";
	}
	
	// 가든스 바이 더베이 페이지
	@RequestMapping("/board/gardensbythebay")
	public String gardensbythebay(Model model) throws Exception {
		logger.info("Gardens By The bay");
		model.addAttribute("starAVG", GardenService.starAVG());
		model.addAttribute("list", GardenService.list());
		model.addAttribute("boardName", "gardensbythebay");
		return "board/gardensbythebay";
	}
	
	// 차이나 타운 페이지
	@RequestMapping("/board/chinatown")
	public String chinatown(Model model) throws Exception {
		logger.info("China Town");
		model.addAttribute("starAVG", ChinaService.starAVG());
		model.addAttribute("list", ChinaService.list());
		model.addAttribute("boardName", "chinatown");
		return "board/chinatown";
	}
	
	// 센토사 섬 페이지
	@RequestMapping("/board/sentosa")
	public String sentosa(Model model) throws Exception {
		logger.info("Sentosa Island");
		model.addAttribute("starAVG", SentosaService.starAVG());
		model.addAttribute("list", SentosaService.list());
		model.addAttribute("boardName", "sentosa");
		return "board/sentosa";
	}
	
	
}
