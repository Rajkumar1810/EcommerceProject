package com.te.ecommerce.ecommercebase.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.ecommerce.ecommercebase.response.AppResponse;

@ControllerAdvice
public class HandlerForException {
	
	@Autowired
	private AppResponse appResponse;

	@ExceptionHandler(EcommerceExpection.class)
	public ResponseEntity<AppResponse> excepHandler(EcommerceExpection ecommerceExpection) {
		appResponse.setMessage(ecommerceExpection.getMessage());
		return new ResponseEntity<AppResponse>(appResponse,HttpStatus.NOT_FOUND); 	
	}
	
}
