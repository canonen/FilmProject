package com.FilmProject.model;


import java.util.Date;

import com.FilmProject.utility.YorumDurumu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = FilmBegeniEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmBegeniEntity extends BaseEntity{

	public static final String TABLE = "film_begeni";
	
	public static final String KULLANICI_ID = "kullanici_id";
	public static final String FILM_ID = "film_id";
	public static final String DURUMU = "durumu";
	public static final String OLUSTURMA_ZAMANI = "olusturma_zamani";
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = KULLANICI_ID)
	private KullaniciEntity kullanici;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FILM_ID)
	private FilmEntity film;
	
	@Column(name = DURUMU)
	@Enumerated(EnumType.STRING)
	private YorumDurumu durumu;
	
	@Column(name = OLUSTURMA_ZAMANI)
	private Date olusturmaZamani;
}
