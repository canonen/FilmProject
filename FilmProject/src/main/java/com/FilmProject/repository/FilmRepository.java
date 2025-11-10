package com.FilmProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.FilmProject.model.FilmEntity;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer>{

	Page<FilmEntity> findAllByOrderByOlusturmaZamaniDesc(Pageable pageable);

}
