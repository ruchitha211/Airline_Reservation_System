package com.capgemini.airlinereservationsystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.airlinereservationsystem.exception.AirlineException;

public class Validations {
	
	public boolean validatedName(String name) throws AirlineException {
		String nameRegEx = "^[A-Za-z\\s]{3,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirlineException("Name should contain atleast 3 characters and only alphabets");
		}
		return result;
	}
		
		public boolean validatedId(int id) throws AirlineException {
			String idRegEx = "[0-9]{1}[0-9]{4}" ;
			boolean result = false;
			if (Pattern.matches(idRegEx, String.valueOf(id))) {
				result = true;
			} else {
				throw new AirlineException("Id should contain exactly 5 digits");
			}
			return result;
		}
	
	public boolean validatedEmail(String email) throws AirlineException {
		String emailRegEx = "[\\w&&[^_]]{3,50}[@]{1}\\D{2,50}[.]{1}\\D{2,50}";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirlineException("Enter Correct Email (@ and extensions(.com))");
		}
		return result;
	}
	public boolean validatedPassword(String password) throws AirlineException {
		String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,20})" ;
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
			result = true;
		} else {
			throw new AirlineException("Password should contain atleast one digit,one uppercase,one lowercase,one symbol(@#$%)"); 
		}
		return result;
	}

	}

	
