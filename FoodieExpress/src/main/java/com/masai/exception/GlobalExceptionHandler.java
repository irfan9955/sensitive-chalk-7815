package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> cartegoryexceptionHandler(CategoryException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<MyErrorDetails> CustomerNotFOundHandler(CustomerNotFound cnf,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(cnf.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MethodArgumentExceptionHandler(MethodArgumentNotValidException ee){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage("Validation error");
		err.setDetails(ee.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyErrorDetails> illegealArgumentHandler(IllegalArgumentException cnf,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(cnf.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(FoodCartException.class)
	public ResponseEntity<MyErrorDetails> foodCartExceptionHandler(FoodCartException cartException, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(cartException.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<MyErrorDetails> ItemNotFoundExceptionHandler(ItemNotFoundException itemException, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(itemException.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrorDetails> BillExceptionHandler(BillException cartException, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(cartException.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> RestaurantExceptionHandler(RestaurantException cartException, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(cartException.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> orderExceptionHandler(OrderException cartException, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(cartException.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException loginException, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(loginException.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
