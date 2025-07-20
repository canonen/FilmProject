package com.FilmProject.dto;

import com.FilmProject.model.YonetmenEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YonetmenResponseDTO extends BaseDTO {
	private String adi;
	private String soyadi;
	
	public YonetmenResponseDTO(YonetmenEntity yonetmen) {
		this.adi = yonetmen.getAdi();
		this.soyadi = yonetmen.getSoyadi();
	}
}
