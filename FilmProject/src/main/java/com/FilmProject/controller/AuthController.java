package com.FilmProject.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.KullaniciRequestDTO;
import com.FilmProject.dto.KullaniciResponseDTO;
import com.FilmProject.dto.LoginRequestDTO;
import com.FilmProject.mapper.KullaniciMapper;
import com.FilmProject.model.KullaniciEntity;
import com.FilmProject.service.AuthService;
import com.FilmProject.service.KullaniciService;
import com.FilmProject.utility.JwtUtil;
import com.FilmProject.utility.StringLabelRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	private final KullaniciService kullaniciService;
	private final KullaniciMapper kullaniciMapper;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto, HttpServletResponse response) {
		String jwtToken = authService.login(dto);
		
		Cookie cookie = new Cookie(JwtUtil.JWT_COOKIE_KEY, jwtToken);
		cookie.setHttpOnly(true);	
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(JwtUtil.EXPIRATION_SECONDS);
		response.addCookie(cookie);

		KullaniciEntity kullaniciEntity = authService.getKullaniciFromLoginRequestDTO(dto);
		KullaniciResponseDTO responseDTO = kullaniciMapper.toDto(kullaniciEntity);
		
	    return ResponseEntity.ok(responseDTO);
	}
	
	@PostMapping("/register")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> register(@Valid @RequestBody KullaniciRequestDTO dto) {
		kullaniciService.register(dto);
		
		return ResponseEntity.ok(StringLabelRepo.SUCCESSFULLY_REGISTERED);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletResponse response){
		
		Cookie cookie = new Cookie(JwtUtil.JWT_COOKIE_KEY, null);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		return ResponseEntity.ok(StringLabelRepo.SUCCESSFULLY_LOGGED_OUT);
	}
}
