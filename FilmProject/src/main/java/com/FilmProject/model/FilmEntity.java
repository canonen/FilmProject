package com.FilmProject.model;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = FilmEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmEntity extends BaseEntity {
	public static final String TABLE = "film";
	
	public static final String BASLIK = "baslik";
	public static final String ACIKLAMA = "aciklama";
	public static final String YAYIN_TARIHI = "yayin_tarihi";
	public static final String YONETMEN_ID = "yonetmen_id";
	public static final String PUANI = "puani";
	public static final String SURE = "sure";
	public static final String OLUSTURMA_ZAMANI = "olusturma_zamani";
	
	@Column(name = BASLIK)
	private String baslik;
	
	@Column(name = ACIKLAMA)
	@Lob
	private String aciklama;
	
	@Column(name = YAYIN_TARIHI)
	private Date yayinTarihi;
	
 	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = YONETMEN_ID)
    private YonetmenEntity yonetmen;
	
	@Column(name = PUANI)
	private int puani;
	
	@Column(name = SURE)
	private int sure;
	
	@Column(name = OLUSTURMA_ZAMANI)
	private Date olusturmaZamani;
	
	@OneToMany(mappedBy = "film", orphanRemoval = false)
	private List<FavoriFilmEntity> favoriFilmler;
	
	@OneToMany(mappedBy = "film", orphanRemoval = false)
	private List<FilmBegeniEntity> filmBegeniler;
	
	@OneToMany(mappedBy = "film", orphanRemoval = false)
	private List<FilmIzlenmeEntity> filmIzlenmeler;
	
	@OneToMany(mappedBy = "film", orphanRemoval = false)
	private List<FilmKategoriEntity> filmKategoriler;
	
	@OneToMany(mappedBy = "film", orphanRemoval = false)
	private List<YorumEntity> yorumlar;
}
