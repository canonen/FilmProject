package com.FilmProject.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = KategoriEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KategoriEntity extends BaseEntity {
	public static final String TABLE = "kategori";
	
	public static final String ADI = "adi";
	
	@Column(name = ADI)
	private String adi;
	
	@OneToMany(mappedBy = "kategori", orphanRemoval = false)
	private List<FilmKategoriEntity> filmKategoriler;
}
