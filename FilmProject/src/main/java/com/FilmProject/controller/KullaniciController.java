package com.FilmProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.KullaniciRequestDTO;
import com.FilmProject.dto.KullaniciResponseDTO;
import com.FilmProject.model.KullaniciEntity;
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
	
	@GetMapping("/me")
	public ResponseEntity<?> getCurrentKullanici(Authentication authentication){
		if (authentication == null || (authentication != null && !authentication.isAuthenticated())) 
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Giriş yapılamadı.");
		
		KullaniciEntity kullaniciEntity = (KullaniciEntity) authentication.getPrincipal();
		
		return ResponseEntity.status(HttpStatus.OK).body(kullaniciEntity);
	}
}
