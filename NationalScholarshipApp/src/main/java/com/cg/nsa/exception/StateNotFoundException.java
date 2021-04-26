package com.cg.nsa.exception;

/******************************************************************************
 * 
 * @author Sushma S
 * Version 1.0
 * Description: This is the implementation class of StateNotFoundException
 * Created date: 22-04-2021
 *
 *****************************************************************************/

public class StateNotFoundException extends RuntimeException {

	/**************************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * This is a no-arg constructor
	 * 
	 **************************************/
	
	public StateNotFoundException() {
		
	}
	
	/****************************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * @param message
	 * This is a parameterized constructor
	 * 
	 *****************************************/
	
    public StateNotFoundException(String message) {
		super(message);
	}
}