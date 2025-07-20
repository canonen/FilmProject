package com.FilmProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FilmProject.dto.YonetmenResponseDTO;
import com.FilmProject.model.YonetmenEntity;
import com.FilmProject.repository.YonetmenRepository;

@Service
public class YonetmenServiceImpl extends BaseServiceImpl implements YonetmenService{
	
	@Autowired
	private final YonetmenRepository yonetmenRepository;
	
	public YonetmenServiceImpl(YonetmenRepository yonetmenRepository) {
		this.yonetmenRepository = yonetmenRepository;
	}
	
	@Override
	public List<YonetmenResponseDTO> getAllYonetmenEntities() {
		List<YonetmenEntity> yonetmenEntities = yonetmenRepository.findAll();
		return yonetmenEntities.stream().map(YonetmenResponseDTO::new).collect(Collectors.toList());
	}

}
