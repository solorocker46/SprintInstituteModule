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
	 * @author Sushma S
	 * Created date: 21-04-2021
	 * This is a no-arg constructor
	 * 
	 **************************************/
	
	public InvalidInstitutionException() {
		
	}

	/****************************************
	 * 
	 * @author Sushma S
	 * Created date: 21-04-2021
	 * @param message
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
	public InvalidInstitutionException(String message) {
		super(message);
		
	}

	/****************************************
	 * 
	 * @author Sushma S
	 * Created date: 21-04-2021
	 * @param cause
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
	public InvalidInstitutionException(Throwable cause) {
		super(cause);
		
	}

	/****************************************
	 * 
	 * @author Sushma S
	 * Created date: 21-04-2021 
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
	 * @author Sushma S
	 * Created date: 21-04-2021
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
