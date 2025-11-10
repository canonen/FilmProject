package com.FilmProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.FilmProject.dto.YonetmenResponseDTO;
import com.FilmProject.model.YonetmenEntity;

@Mapper(componentModel = "spring")
public interface YonetmenMapper {
	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "adi", source = "adi")
	@Mapping(target = "soyadi", source = "soyadi")
	YonetmenResponseDTO toDto(YonetmenEntity yonetmenEntity);
}
