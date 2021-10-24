package br.com.jpa.tarefas.excecoes;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<?> handleApiRequestException(Exception apiRequestException){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ExceptionModel apiException = new ExceptionModel (
				apiRequestException.getMessage(), 
				badRequest, 
				ZonedDateTime.now()
		);
		
		return new ResponseEntity<>(apiException, badRequest);	
	}
}
