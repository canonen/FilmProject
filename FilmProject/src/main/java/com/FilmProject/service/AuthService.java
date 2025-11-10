package com.FilmProject.service;

import java.io.InvalidClassException;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.FilmProject.dto.LoginRequestDTO;
import com.FilmProject.exception.InvalidCredentialsException;
import com.FilmProject.exception.InvalidCredentialsException.TYPE;
import com.FilmProject.model.KullaniciEntity;
import com.FilmProject.repository.KullaniciRepository;
import com.FilmProject.utility.JwtUtil;

@Service
public class AuthService {
	private final KullaniciRepository kullaniciRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	public AuthService(KullaniciRepository kullaniciRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.kullaniciRepository = kullaniciRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	public KullaniciEntity getKullaniciFromLoginRequestDTO(LoginRequestDTO dto) {
		Optional<KullaniciEntity> kullaniciOpt = dto.getUsernameOrEmail().contains("@") 
				?
				kullaniciRepository.findByEmail(dto.getUsernameOrEmail())
								:
				kullaniciRepository.findByKullaniciAdi(dto.getUsernameOrEmail());

		return kullaniciOpt.orElseGet(null);
	}
	
	public String login(LoginRequestDTO dto) {
		KullaniciEntity kullanici = getKullaniciFromLoginRequestDTO(dto);

		if (kullanici == null) 
			throw new InvalidCredentialsException(TYPE.USERNAME_OR_EMAIL);
		
		if (!passwordEncoder.matches(dto.getPassword(), kullanici.getSifre())) 
			throw new InvalidCredentialsException(TYPE.PASSWORD);
		
		return jwtUtil.generateToken(kullanici);
	}
}
