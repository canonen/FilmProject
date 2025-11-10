package com.FilmProject.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.FilmProject.dto.FilmResponseDTO;
import com.FilmProject.model.FilmEntity;

public interface FilmService {

	public List<FilmResponseDTO> getRecentMovies(int page, int size);
	
}
