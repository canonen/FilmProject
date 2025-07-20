package com.FilmProject.service;

import java.util.List;

import com.FilmProject.dto.KullaniciRequestDTO;
import com.FilmProject.dto.KullaniciResponseDTO;
import com.FilmProject.dto.LoginRequestDTO;

public interface KullaniciService {
	
	public List<KullaniciResponseDTO> getAllKullaniciEntities();
	
	public void register(KullaniciRequestDTO dto);
	
}
