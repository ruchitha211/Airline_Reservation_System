package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@SuppressWarnings("serial")
public class FlightDetailsInfoBean implements Serializable{
	
	private String flightcode;
	private String flightname;
	private String source;
	private String destination;
//	private Time departure_time;
	private LocalDateTime arrival_time;

	
	

	public FlightDetailsInfoBean(String flightcode, String flightname, String source, String destination, LocalDateTime arrival_time) {
		this.flightcode=flightcode;
		this.flightname=flightname;
		this.source=source;
		this.destination=destination;
		this.arrival_time=arrival_time;
		
	}
	
	
	
	public FlightDetailsInfoBean() {
		
	}



	public String getFlightcode() {
		return flightcode;
	}
	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDateTime getArrival_time() {
		return arrival_time;
	}



	public void setArrival_time(LocalDateTime arrival_time) {
		this.arrival_time = arrival_time;
	}


	@Override
	public String toString() {
		
		return "FlightDetailsInfoBean [flightcode" + flightcode + ", flightname=" + flightname +",source "+source+"destination" +destination+"]";
	}
	
	

}
