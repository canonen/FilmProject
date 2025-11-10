package com.FilmProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.FilmResponseDTO;
import com.FilmProject.service.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController extends BaseController{
	
	private final FilmService filmService;
	
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@GetMapping("/recent-movies")
	public ResponseEntity<List<FilmResponseDTO>> getRecentMovies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
		return ResponseEntity.ok(filmService.getRecentMovies(page, size));
	}
}
