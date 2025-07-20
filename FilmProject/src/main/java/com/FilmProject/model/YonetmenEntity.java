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
@Table(name = YonetmenEntity.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YonetmenEntity extends BaseEntity{
	public static final String TABLE = "yonetmen";
	
	public static final String ADI = "adi";
	public static final String SOYADI = "soyadi";
	
	@Column(name = ADI)
	private String adi;
	
	@Column(name = SOYADI)
	private String soyadi;

	@OneToMany(mappedBy = "yonetmen", orphanRemoval = false)
    private List<FilmEntity> filmler;
	
}
