package com.cg.nsa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*************************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is global exception class to handle all exceptions
 * Created date: 21-04-2021
 * 
 *************************************************************************/

@RestControllerAdvice
public class GlobalException {

	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(InvalidInstitutionException.class)
	public ResponseEntity<Object> handleException(InvalidInstitutionException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<Object> handleException(UserIdNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(UniqueElementException.class)
	public ResponseEntity<Object> handleException(UniqueElementException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleException(ValidationException exception)
	{
		return new ResponseEntity<Object>(exception.getMessages(), HttpStatus.BAD_REQUEST);
	}
	
}
