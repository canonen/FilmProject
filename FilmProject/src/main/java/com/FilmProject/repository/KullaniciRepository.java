package com.FilmProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.FilmProject.model.KullaniciEntity;

@Repository
public interface KullaniciRepository extends JpaRepository<KullaniciEntity, Integer>{

	boolean existsByEmail(String email);

	boolean existsByKullaniciAdi(String kullaniciAdi);
	
	Optional<KullaniciEntity> findByEmail(String email);
	
	Optional<KullaniciEntity> findByKullaniciAdi(String kullaniciAdi);
}
