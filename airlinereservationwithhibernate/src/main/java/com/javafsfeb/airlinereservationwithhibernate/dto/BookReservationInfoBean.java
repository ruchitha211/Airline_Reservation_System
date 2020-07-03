package com.javafsfeb.airlinereservationwithhibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="reservations")
public class BookReservationInfoBean implements Serializable {
	
    
//	private RegistrationIfoBean user;
//	private FlightDetailsInfoBean fbean;
	@Id
	@Column(name="passport_number")
	private String passportno;
	@Column(name="visa_number")
	private String visano;
	@Column(name="noof_seats")
	private int noofseats;
	private int flightcode;
	private int id;

 

}




