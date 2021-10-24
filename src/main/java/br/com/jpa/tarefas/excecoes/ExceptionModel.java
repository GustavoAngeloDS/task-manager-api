package br.com.jpa.tarefas.excecoes;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionModel {
	private String message;
	private HttpStatus httpStatus;
	private ZonedDateTime timestamp;
	
	public ExceptionModel(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
}
