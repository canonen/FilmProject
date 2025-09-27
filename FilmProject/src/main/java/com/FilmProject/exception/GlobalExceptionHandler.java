package com.FilmProject.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.FilmProject.model.ErrorModel;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorModel> handleEmailDuplicate(EmailAlreadyExistsException ex){
		ErrorModel errorModel = new ErrorModel(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"EMAIL_ALREADY_IN_USE",
				ex.getMessage()
				);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}
	
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<ErrorModel> handleUsernameDuplicate(UsernameAlreadyExistsException ex){
		ErrorModel errorModel = new ErrorModel(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"USERNAME_ALREADY_IN_USE",
				ex.getMessage()
				);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorModel> handleInvalidCredentialsException(InvalidCredentialsException ex){
		ErrorModel errorModel = new ErrorModel(
				LocalDateTime.now(),
				HttpStatus.UNAUTHORIZED.value(),
				ex.getType().getCode(),
				ex.getType().getMessage()
				);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorModel);
	}
}
