package com.javafsfeb.airlinereservationwithjdbc.dto;

import java.io.Serializable;


import java.time.LocalDate;

import java.time.LocalTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class FlightDetailsInfoBean implements Serializable {

	private int flightcode;
	private String flightname;
	private String source;
	private String destination;
	private LocalTime departure_time;
	private LocalTime arrival_time;
	private LocalDate arrivalDate;
	private LocalDate departuredate;

}
