package com.FilmProject.exception;

import com.FilmProject.utility.StringLabelRepo;

public class MovieNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public MovieNotFoundException() {
		super(StringLabelRepo.MOVIE_NOT_FOUND);
	}
	
}
