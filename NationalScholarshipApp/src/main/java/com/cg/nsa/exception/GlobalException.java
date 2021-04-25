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
	public ResponseEntity<Object> handleException(InvalidInstitutionException invalidInstitutionException)
	{
		return new ResponseEntity<Object>(invalidInstitutionException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<Object> handleException(UserIdNotFoundException userIdNotFoundException)
	{
		return new ResponseEntity<Object>(userIdNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(UniqueElementException.class)
	public ResponseEntity<Object> handleException(UniqueElementException uniqueElementException)
	{
		return new ResponseEntity<Object>(uniqueElementException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleException(ValidationException validationException)
	{
		return new ResponseEntity<Object>(validationException.getMessages(), HttpStatus.BAD_REQUEST);
	}
	
	/****************************************************************************************
	 * 
	 * @param exception
	 * @return this method returns a new ResponseEntity with an appropriate response code
	 * 
	 ***************************************************************************************/
	
	@ExceptionHandler(StateNotFoundException.class)
	public ResponseEntity<Object> handleException(StateNotFoundException stateNotFoundException)
	{
		return new ResponseEntity<Object>(stateNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
}
