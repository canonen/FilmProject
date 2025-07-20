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

@Service
public class AuthService {
	private final KullaniciRepository kullaniciRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthService(KullaniciRepository kullaniciRepository, PasswordEncoder passwordEncoder) {
		this.kullaniciRepository = kullaniciRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void login(LoginRequestDTO dto) {
		Optional<KullaniciEntity> kullaniciOpt = dto.getUsernameOrEmail().contains("@") 
																		?
														kullaniciRepository.findByEmail(dto.getUsernameOrEmail())
																		:
														kullaniciRepository.findByKullaniciAdi(dto.getUsernameOrEmail());
		
		KullaniciEntity kullaniciEntity = kullaniciOpt
				.orElseThrow(() -> new InvalidCredentialsException(TYPE.USERNAME_OR_EMAIL));
		
		
		if (!passwordEncoder.matches(dto.getPassword(), kullaniciEntity.getSifre())) 
			throw new InvalidCredentialsException(TYPE.PASSWORD);
	}
}
