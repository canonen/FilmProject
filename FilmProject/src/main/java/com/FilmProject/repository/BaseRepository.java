package com.FilmProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FilmProject.model.BaseEntity;

//Tüm repositorylerin extend edecegi class
public interface BaseRepository extends JpaRepository<BaseEntity, Integer> {

}
