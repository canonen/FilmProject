package com.FilmProject.exception;

import com.FilmProject.utility.StringLabelRepo;

public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String email) {
		super(StringLabelRepo.EMAIL_ALREADY_EXISTS + email);
    }
}
