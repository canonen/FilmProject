package com.FilmProject.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.FilmProject.utility.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = KullaniciEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciEntity extends BaseEntity{
	
	public static final String TABLE = "kullanici";
	
	public static final String ADI = "adi";
	public static final String SOYADI = "soyadi";
	public static final String KULLANICI_ADI = "kullanici_adi";
	public static final String EMAIL = "email";
	public static final String SIFRE = "sifre";
	public static final String ROL = "rol";
	public static final String DOGUM_TARIHI = "dogum_tarihi";
	public static final String OLUSTURMA_ZAMANI = "olusturma_zamani";
	
	
	@Column(name = ADI)
	private String adi;
	
	@Column(name = SOYADI)
	private String soyadi;
	
	@Column(name = KULLANICI_ADI)
	private String kullaniciAdi;
	
	@Column(name = EMAIL)
	private String email;
	
	@Column(name = SIFRE)
	private String sifre;
	
	@Column(name = ROL)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = DOGUM_TARIHI)
	private Date dogumTarihi;
	
	@Column(name = OLUSTURMA_ZAMANI)
	private LocalDateTime olusturmaZamani;
	
	@OneToMany(mappedBy = "kullanici", orphanRemoval = false, fetch = FetchType.EAGER)
	private List<FavoriFilmEntity> favoriFilmler;
	
	@OneToMany(mappedBy = "kullanici", orphanRemoval = false, fetch = FetchType.EAGER)
	private List<FilmBegeniEntity> filmBegeniler;
	
	@OneToMany(mappedBy = "kullanici", orphanRemoval = false, fetch = FetchType.EAGER)
	private List<FilmIzlenmeEntity> filmIzlenmeler;
	
	@OneToMany(mappedBy = "kullanici", orphanRemoval = false, fetch = FetchType.EAGER)
	private List<YorumEntity> yorumlar;
}
