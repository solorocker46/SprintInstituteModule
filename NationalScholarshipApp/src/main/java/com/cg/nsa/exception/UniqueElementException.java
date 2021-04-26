package com.cg.nsa.exception;

/*******************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the implementation class of UniqueElementException
 * Created date: 22-04-2021
 * 
 *********************************************************************************/

public class UniqueElementException extends RuntimeException{

	/***********************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * This is a no-arg constructor 
	 * 
	 **********************************/
	
	public UniqueElementException() {
		
	}
	
	/***************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * @param message
	 * This is a parameterized constructor with field - message
	 * 
	 ***************************************************************/
	
	public UniqueElementException(String message)
	{
		super(message);
	}
}