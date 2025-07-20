package com.FilmProject.exception;

import com.FilmProject.utility.StringLabelRepo;

public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private TYPE type;
	
	//Error Type
	public enum TYPE{
		USERNAME_OR_EMAIL("ERROR_INVALID_EMAIL", StringLabelRepo.ERROR_INVALID_EMAIL),
		PASSWORD("ERROR_INVALID_PASSWORD", StringLabelRepo.ERROR_INVALID_PASSWORD);
			
		private final String code;
		private final String message;
		
		TYPE(String code,String message) {
			this.code = code;
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}

		public String getCode() {
			return code;
		}
	}; 
	
	public InvalidCredentialsException(TYPE errorType) {
		super(errorType.getMessage());
		this.setType(errorType);
		
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

}
