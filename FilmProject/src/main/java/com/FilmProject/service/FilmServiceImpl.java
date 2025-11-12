package com.FilmProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.FilmProject.dto.FilmResponseDTO;
import com.FilmProject.exception.MovieNotFoundException;
import com.FilmProject.mapper.FilmMapper;
import com.FilmProject.model.FilmEntity;
import com.FilmProject.repository.FilmRepository;

@Service
public class FilmServiceImpl extends BaseServiceImpl implements FilmService {

	private final FilmRepository filmRepository;
	private final FilmMapper filmMapper;

	public FilmServiceImpl(FilmRepository filmRepository, FilmMapper filmMapper) {
		this.filmRepository = filmRepository;
		this.filmMapper = filmMapper;
	}

	@Override
	public List<FilmResponseDTO> getRecentMovies(int page, int size) {
		Page<FilmEntity> filmPages = filmRepository.findAllByOrderByOlusturmaZamaniDesc(PageRequest.of(page, size));
		return filmPages.stream().map(filmMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public FilmResponseDTO getMovie(int id) {
		return filmRepository.findById(id)
				.map(filmMapper::toDto)
				.orElseThrow(MovieNotFoundException::new);
	}
	
}
