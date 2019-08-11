package com.pretia.movie.movieservice.error.model;

/**
 * This object defines structure of Error Response.
 * @author Sougata Maitra
 * @version 1.0
 */
public class ApiError {
	String errorMessage;
	String exceptionCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}



}
