package com.pretia.movie.movieservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pretia.movie.movieservice.error.model.ApiError;
import com.pretia.movie.movieservice.util.GenericServiceConstant;
/**
 * This class handles all un-handled exceptions in the application and provides proper error message to client
 * 
 * @author Sougata Maitra
 *
 */
@ControllerAdvice
public class PretiaServiceAdvice {
	/**
	 * This method handles Exception  and send HTTP 500 error code 
	 * @param ex Exception
	 * @return {@link ApiError}
	 */
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError genericException(Exception ex) {
		ApiError res = new ApiError();
		res.setExceptionCode(GenericServiceConstant.GENERIC_ERROR_CODE);
		res.setErrorMessage(ex.getMessage());
		ex.printStackTrace();
		return res;
	}

}
