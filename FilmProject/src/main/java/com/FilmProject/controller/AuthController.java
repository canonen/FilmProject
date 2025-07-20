package com.FilmProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.LoginRequestDTO;
import com.FilmProject.dto.LoginResponseDTO;
import com.FilmProject.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
		authService.login(dto);
		return new LoginResponseDTO("Giriş başarılı.");
	}
}
