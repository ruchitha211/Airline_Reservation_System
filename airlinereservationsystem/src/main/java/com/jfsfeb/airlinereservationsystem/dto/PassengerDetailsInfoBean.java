package com.jfsfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class PassengerDetailsInfoBean  implements Serializable{
	
	private int passengerid;
	private String passportnumber;
	private String visano;
	private String source;
	private String destination;
	
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private int contactno;
	private int age;
	private String gender;

}
	
