package com.FilmProject.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = YorumEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YorumEntity extends BaseEntity{
	public static final String TABLE = "yorum";
	
	public static final String KULLANICI_ID = "kullanici_id";
	public static final String FILM_ID = "film_id";
	public static final String ICERIK = "icerik";
	public static final String OLUSTURMA_ZAMANI = "olusturma_zamani";
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = KULLANICI_ID)
	private KullaniciEntity kullanici;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FILM_ID)
	private FilmEntity film;
	
	@Column(name = ICERIK)
	private String icerik;
	
	@Column(name = OLUSTURMA_ZAMANI)
	private Date olusturmaZamani;
}
