package com.te.ecommerce.ecommercebase.exception;


public class EcommerceExpection extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1593733574599752400L;

//	private HttpStatus status;
	private String message;

	public EcommerceExpection(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

//	public EcommerceExpection(HttpStatus status, String message) {
//		super();
//		this.status = status;
//		this.message = message;
//	}

}
