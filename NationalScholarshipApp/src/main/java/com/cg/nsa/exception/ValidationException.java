package com.cg.nsa.exception;

import java.util.ArrayList;
import java.util.List;

/********************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the implementation class of UserIdNotFoundException
 * Created date: 22-04-2021
 * 
 ********************************************************************************/

public class ValidationException extends RuntimeException
{
	List<String> messages = new ArrayList<String>();
	
	/*******************************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * Non Parameterized Constructor
	 *
	 *******************************************/
	
	public ValidationException()
	{
		
	}
	
	/********************************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * Parameterized Constructor
	 * @param messages
	 *
	 ********************************************/
	
	public ValidationException(List<String> messages) 
	{
		super();
		this.messages = messages;
	}

	/*********************************************************
	 * 
	 * @author Sushma S
	 * Created date: 22-04-2021
	 * @return - this method returns a list of messages.
	 *
	 *********************************************************/
	
	public List<String> getMessages() 
	{
		return messages;
	}
	

}