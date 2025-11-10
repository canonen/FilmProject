package com.FilmProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.FilmProject.dto.FilmResponseDTO;
import com.FilmProject.model.FilmEntity;

@Mapper(componentModel = "spring", uses = {YonetmenMapper.class})
public interface FilmMapper {

	@Mapping(target = "id", source = "id")
	@Mapping(target = "baslik", source = "baslik")
	@Mapping(target = "aciklama", source = "aciklama")
	@Mapping(target = "yayinTarihi", source = "yayinTarihi")
	@Mapping(target = "yonetmen", source = "yonetmen")
	@Mapping(target = "puani", source = "puani")
	@Mapping(target = "sure", source = "sure")
	@Mapping(target = "olusturmaZamani", source = "olusturmaZamani")
	FilmResponseDTO toDto(FilmEntity filmEntity);
	
	FilmEntity toEntity(FilmResponseDTO responseDTO);
}
