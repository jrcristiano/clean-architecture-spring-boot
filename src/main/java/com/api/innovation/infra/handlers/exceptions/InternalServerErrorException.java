package com.api.innovation.infra.handlers.exceptions;

public class InternalServerErrorException extends RuntimeException {
	static final Long serialVersionUID = 1L;

	public InternalServerErrorException(String message) {
		super(message);
	}
}
