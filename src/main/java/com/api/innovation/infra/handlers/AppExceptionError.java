package com.api.innovation.infra.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.innovation.infra.handlers.exceptions.BadRequestErrorException;
import com.api.innovation.infra.handlers.exceptions.ConflictErrorException;
import com.api.innovation.infra.handlers.exceptions.EntityNotFoundErrorException;
import com.api.innovation.infra.handlers.exceptions.UnauthorizedErrorException;

@ControllerAdvice
public class AppExceptionError extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = BadRequestErrorException.class)
	public final ResponseEntity<ResponseError> handleBadRequestException(
		BadRequestErrorException ex,
		WebRequest request
	) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ArrayList<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		ResponseError responseError = new ResponseError()
			.setMessage("Bad Request")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = UnauthorizedErrorException.class)
	public final ResponseEntity<ResponseError> handleUnauthorizedException(
		UnauthorizedErrorException ex,
		WebRequest request
	) {
		HttpStatus status = HttpStatus.UNAUTHORIZED;

		ArrayList<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		ResponseError responseError = new ResponseError()
			.setMessage("Unauthorized")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = EntityNotFoundErrorException.class)
	public final ResponseEntity<ResponseError> handleEntityNotFoundException(EntityNotFoundErrorException ex) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		ArrayList<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		ResponseError responseError = new ResponseError()
			.setMessage("Not Found")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = ConflictErrorException.class)
	public final ResponseEntity<ResponseError> handleConflictErrorException(ConflictErrorException ex) {
		HttpStatus status = HttpStatus.CONFLICT;

		ArrayList<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		ResponseError responseError = new ResponseError()
			.setMessage("Conflict")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request
	) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		ArrayList<String> errors = new ArrayList<String>();
		for (FieldError error : fieldErrors) {
			errors.add(error.getDefaultMessage());
		}

		ResponseError responseError = new ResponseError()
			.setDetails(errors)
			.setMessage("Validation Failed");

		return handleExceptionInternal(ex, responseError, headers, status, request);
	}

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ResponseError> handleAllExceptions(
		Exception exception,
		WebRequest request
	) {

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ArrayList<String> details = new ArrayList<String>();
		details.add(exception.getLocalizedMessage());

		ResponseError responseError = new ResponseError()
			.setMessage("Internal Server Error")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}
}
