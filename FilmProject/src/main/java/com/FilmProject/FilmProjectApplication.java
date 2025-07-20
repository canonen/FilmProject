package com.FilmProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.FilmProject.controller", 
		"com.FilmProject.repository",
		"com.FilmProject.service", 
		"com.FilmProject.model", 
		"com.FilmProject.dto",
		"com.FilmProject.utility",
		"com.FilmProject.config",
		"com.FilmProject.exception",
		"com.FilmProject.security"
		})
public class FilmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmProjectApplication.class, args);
	}

}
