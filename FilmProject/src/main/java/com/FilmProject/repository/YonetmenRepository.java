package com.FilmProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FilmProject.model.YonetmenEntity;

@Repository
public interface YonetmenRepository extends JpaRepository<YonetmenEntity, Integer>{

}
