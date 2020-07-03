package com.javafsfeb.airlinereservationwithjdbc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.javafsfeb.airlinereservationwithjdbc.exception.AirlineException;


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
		
		public boolean validatedMobile(Long mobile) throws AirlineException {
			//String mobileRegEx = "[0-9]{1}[0-9]{4}" ;
			String mobileRegEx = "(0/91)?[6-9][0-9]{9}" ;
			boolean result = false;
			if (Pattern.matches(mobileRegEx, String.valueOf(mobile))) {
				result = true;
			} else {
				throw new AirlineException("Mobile Number  will start between  6 to 9 and It should contain 10 numbers");
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
		String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" ;
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
			result = true;
		} else {
			throw new AirlineException("Password should contain atleast length of 8, one digit, one uppercase, one lowercase, one symbol(@#$%)"); 
		}
		return result;
	}
	
	 public  boolean  isValidVisaCardNo(String visano)   { 
	        String visanumber = "^4[0-9]{12}(?:[0-9]{3})?$"; 
	        boolean result =false;
	        Pattern p = Pattern.compile(visanumber); 
	        Matcher m = p.matcher(visano); 
	        if (m.matches()) { 
	           result=true;
	        } else {
	        	throw new AirlineException("The String should starts with 4 and next 12 digits from 0 to 9");
	        }
	        return result; 

	    }
	 
	 public boolean isValidPassportNo(String passportno)   { 
	     
	        String passportnumber = "^[A-PR-WYa-pr-wy][1-9]\\d" + "\\s?\\d{4}[1-9]$"; 
	        boolean result=false;
	        Pattern p = Pattern.compile(passportnumber); 
	        Matcher m = p.matcher(passportno); 
	        if( m.matches()) {
	        	result= true;
	        }else {
	        	throw new AirlineException("The String should starts one  capital letter ");

	        }
	
	        return result; 
	    } 
	}

	
