package com.FilmProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.YonetmenResponseDTO;
import com.FilmProject.service.YonetmenService;

@RestController
@RequestMapping("/api/yonetmen")
public class YonetmenController {
	private final YonetmenService yonetmenService;
	
	public YonetmenController(YonetmenService yonetmenService) {
		this.yonetmenService = yonetmenService;
	}
	
	@GetMapping("/get-all")
	public List<YonetmenResponseDTO> getAllYonetmenler(){
		return yonetmenService.getAllYonetmenEntities();
	}
}
