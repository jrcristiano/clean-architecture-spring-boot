package com.api.innovation.infra.handlers.exceptions;

public class ValidationFailedErrorException extends RuntimeException {
	static final Long serialVersionUID = 1L;

	public ValidationFailedErrorException(String message) {
		super(message);
	}
}
