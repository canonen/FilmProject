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
	
	@NotBlank(message = "'adi' field must be filled")
	private String adi;
	
	@NotBlank(message = "'soyadi' field must be filled")
	private String soyadi;
	
	@NotBlank(message = "'kullaniciAdi' field must be filled")
	private String kullaniciAdi;
	
	@Email
	@NotBlank(message = "'email' field must be filled")
	private String email;
	
	@Size(min = 6, max = 15)
	private String sifre;
	
	@NotNull(message = "'rol' field must be filled")
    private Role rol;
	
	@NotNull(message = "'dogumTarihi' field must be filled")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dogumTarihi;
	
}