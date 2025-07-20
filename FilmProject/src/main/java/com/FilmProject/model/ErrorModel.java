package com.FilmProject.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {
	private LocalDateTime olusmaZamani;
	private int status;
	private String errorCode;
	private String message;
}
