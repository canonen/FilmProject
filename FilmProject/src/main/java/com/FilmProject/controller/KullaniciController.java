package com.FilmProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.KullaniciRequestDTO;
import com.FilmProject.dto.KullaniciResponseDTO;
import com.FilmProject.service.KullaniciService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/kullanici")
public class KullaniciController extends BaseController {

	private final KullaniciService kullaniciService;
	
	public KullaniciController(KullaniciService kullaniciService) {
		this.kullaniciService = kullaniciService;
	}
	
	@GetMapping("/get-all")
	public List<KullaniciResponseDTO> getAllKullanicilar(){
		return kullaniciService.getAllKullaniciEntities();
	}
	
	@PostMapping("/register")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void register(@Valid @RequestBody KullaniciRequestDTO dto) {
		kullaniciService.register(dto);
	}
}
