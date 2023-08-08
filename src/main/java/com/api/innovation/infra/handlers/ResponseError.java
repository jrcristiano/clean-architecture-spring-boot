package com.api.innovation.infra.handlers;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;

@Getter
public class ResponseError implements Serializable {
	private static final Long serialVersionUID = 1L;

	private String message;

	private List<String> details;

	public ResponseError setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseError setDetails(List<String> details) {
		this.details = details;
		return this;
	}
}
