package com.api.innovation.infra.handlers.exceptions;

public class UnauthorizedErrorException extends RuntimeException {
    static final Long serialVersionUID = 1L;

	public UnauthorizedErrorException(String message) {
		super(message);
	}
}
