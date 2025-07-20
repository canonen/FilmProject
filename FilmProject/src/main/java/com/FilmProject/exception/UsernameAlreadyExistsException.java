package com.FilmProject.exception;

import com.FilmProject.utility.StringLabelRepo;

public class UsernameAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException(String kullaniciAdi) {
		super(StringLabelRepo.USERNAME_ALREADY_EXISTS + kullaniciAdi);
	}
}
