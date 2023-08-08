package com.api.innovation.infra.handlers.exceptions;

public class EntityNotFoundErrorException extends RuntimeException {
	private static final Long serialVersionUID = 1L;

	public EntityNotFoundErrorException(String message) {
		super(message);
	}
}
