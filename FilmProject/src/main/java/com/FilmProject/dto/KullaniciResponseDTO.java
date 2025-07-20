package com.FilmProject.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.FilmProject.model.KullaniciEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciResponseDTO extends BaseDTO{
	private String adi;
	private String soyadi;
	private String kullaniciAdi;
	private String email;
	private String sifre;
	private LocalDateTime olusturmaZamani;
	
	public KullaniciResponseDTO(KullaniciEntity kullanici) {
		this.adi = kullanici.getAdi();
		this.soyadi = kullanici.getSoyadi();
		this.email = kullanici.getEmail();
		this.sifre = kullanici.getSifre();
		this.olusturmaZamani = kullanici.getOlusturmaZamani();
	}
}
