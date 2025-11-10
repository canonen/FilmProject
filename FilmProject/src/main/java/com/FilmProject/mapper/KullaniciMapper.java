package com.FilmProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.FilmProject.dto.KullaniciResponseDTO;
import com.FilmProject.model.KullaniciEntity;
import com.FilmProject.utility.Role;

@Mapper(componentModel = "spring")
public interface KullaniciMapper {

	@Mapping(target = "id", source = "id")
	@Mapping(target = "adi", source = "adi")
	@Mapping(target = "soyadi", source = "soyadi")
	@Mapping(target = "kullaniciAdi", source = "kullaniciAdi")
	@Mapping(target = "email", source = "email")
	@Mapping(target = "olusturmaZamani", source = "olusturmaZamani")
	@Mapping(target = "role", source = "role")
	KullaniciResponseDTO toDto(KullaniciEntity kullaniciEntity);
	
	KullaniciEntity toEntity(KullaniciResponseDTO dto);
	
	default String getRole(Role role) {
		return role != null ? role.toString() : null;
	}
}
