package com.cg.nsa.exception;

/***********************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the implementation class of InvalidInstitutionException
 * Created date: 21-04-2021
 * 
 ************************************************************************************/

public class InvalidInstitutionException extends RuntimeException {

	/**************************************
	 * 
	 * This is a no-arg constructor
	 * 
	 **************************************/
	
	public InvalidInstitutionException() {
		
	}

	/****************************************
	 * 
	 * @param message
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
	public InvalidInstitutionException(String message) {
		super(message);
		
	}

	/****************************************
	 * 
	 * @param cause
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
	public InvalidInstitutionException(Throwable cause) {
		super(cause);
		
	}

	/****************************************
	 * 
	 * @param message
	 * @param cause
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
	public InvalidInstitutionException(String message, Throwable cause) {
		super(message, cause);

	}

	/****************************************
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
	public InvalidInstitutionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
