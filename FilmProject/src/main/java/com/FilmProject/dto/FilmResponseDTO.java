package com.FilmProject.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmResponseDTO extends BaseDTO {
	
	private int id;
	private String baslik;
	private String aciklama;
	private Date yayinTarihi;
	private YonetmenResponseDTO yonetmen;
	private int puani;
	private int sure;
	private Date olusturmaZamani;
}
