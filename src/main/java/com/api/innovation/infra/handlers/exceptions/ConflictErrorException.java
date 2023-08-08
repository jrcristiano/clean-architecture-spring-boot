package com.api.innovation.infra.handlers.exceptions;

public class ConflictErrorException extends RuntimeException {
	private static final Long serialVersionUID = 1L;

	public ConflictErrorException(String message) {
		super(message);
	}
}
