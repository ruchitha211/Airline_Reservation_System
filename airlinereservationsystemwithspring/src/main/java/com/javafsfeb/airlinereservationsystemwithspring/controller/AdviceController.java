package com.javafsfeb.airlinereservationsystemwithspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javafsfeb.airlinereservationsystemwithspring.dto.AirlineResponce;
import com.javafsfeb.airlinereservationsystemwithspring.exception.AirlineException;

@RestControllerAdvice
public class AdviceController {
	@ExceptionHandler(AirlineException.class)
	public AirlineResponce handleAirlineException(AirlineException exception) {
		AirlineResponce response=new AirlineResponce();
		response.setError(true);
		response.setMessage(exception.getMessage());
		return response;
	}
  
	@ExceptionHandler(Exception.class)
	public AirlineResponce handleAirlineException(Exception e) {
		AirlineResponce response=new AirlineResponce();
		response.setError(true);
		response.setMessage(e.getMessage());
		return response;
	}
}//End of the class
