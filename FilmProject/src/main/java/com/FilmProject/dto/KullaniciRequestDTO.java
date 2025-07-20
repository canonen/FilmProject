package com.FilmProject.dto;

import java.util.Date;

import com.FilmProject.utility.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciRequestDTO {
	
	@NotBlank
	private String adi;
	
	@NotBlank
	private String soyadi;
	
	@NotBlank
	private String kullaniciAdi;
	
	@Email
	@NotBlank
	private String email;
	
	@Size(min = 6, max = 15)
	private String sifre;
	
	@NotNull
    private Role rol;
	
	@NotNull 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dogumTarihi;
	
}