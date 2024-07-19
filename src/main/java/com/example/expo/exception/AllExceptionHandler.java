package com.example.expo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllExceptionHandler {
	
	
	@ExceptionHandler(UserNotFound.class)
	public @ResponseBody ExceptionResponse handleException(HttpServletRequest request , UserNotFound exception){
		ExceptionResponse response = new ExceptionResponse();
		response.setGetUri(request.getRequestURI());
		response.setErrorMsg(exception.getMessage());
		return response;
	}
}
