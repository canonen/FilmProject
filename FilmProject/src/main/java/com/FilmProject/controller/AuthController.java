package com.FilmProject.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.FilmProject.dto.KullaniciRequestDTO;
import com.FilmProject.dto.LoginRequestDTO;
import com.FilmProject.service.AuthService;
import com.FilmProject.service.KullaniciService;
import com.FilmProject.utility.JwtUtil;

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

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto, HttpServletResponse response) {
		String jwtToken = authService.login(dto);
		
		Cookie cookie = new Cookie("token", jwtToken);
		cookie.setHttpOnly(true);	
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(JwtUtil.EXPIRATION_SECONDS);
		response.addCookie(cookie);
		
	    return ResponseEntity.ok("Giriş başarılı");
	}
	
	@PostMapping("/register")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void register(@Valid @RequestBody KullaniciRequestDTO dto) {
		kullaniciService.register(dto);
	}
}
