package com.example.demo.customexception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity<Object>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(Exception ex, WebRequest req){
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Record not found", details);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.toString());
		}
		
		ErrorResponse error = new ErrorResponse("Vaidation Failed", details);
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
	}
}
