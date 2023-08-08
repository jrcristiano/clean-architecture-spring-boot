package com.api.innovation.infra.handlers.exceptions;

public class BadRequestErrorException extends RuntimeException {
	static final Long serialVersionUID = 1L;

	public BadRequestErrorException(String message) {
		super(message);
	}
}
