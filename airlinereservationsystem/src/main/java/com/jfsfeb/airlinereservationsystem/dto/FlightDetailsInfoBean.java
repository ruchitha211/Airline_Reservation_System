package com.jfsfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import java.time.LocalDateTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class FlightDetailsInfoBean implements Serializable {

	private String flightcode;
	private String flightname;
	private String source;
	private String destination;
	private LocalDateTime departure_time;
	private LocalDateTime arrival_time;

}
