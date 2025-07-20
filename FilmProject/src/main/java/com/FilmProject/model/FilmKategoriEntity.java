package com.FilmProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = FilmKategoriEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmKategoriEntity extends BaseEntity {
	public static final String TABLE = "film_kategori";
	
	public static final String FILM_ID = "film_id";
	public static final String KATEGORI_ID = "kategori_id";
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FILM_ID)
	private FilmEntity film;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = KATEGORI_ID)
	private KategoriEntity kategori;
}
