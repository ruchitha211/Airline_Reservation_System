package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@SuppressWarnings("serial")
public class BookReservationInfoBean  implements Serializable{
	
	private  int regid;
	private String flightcode;
	private int Passengerid;
//	private Date date;
	private int noofseats;
	private String status;
//	private Time departuretime;
	private String destination;
	
	public BookReservationInfoBean() {
		
	}
	
	
	public BookReservationInfoBean(int regid, String flightcode, int Passengerid, int noofseats, String status, String destination) {
		  super();
	      this.regid=regid;
	      this.flightcode=flightcode;
	      this.Passengerid=Passengerid;
	      this.noofseats=noofseats;
	      this.status=status;
	      this.destination=destination;
	}
	
	

	



	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public String getFlightcode() {
		return flightcode;
	}
	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}
	public int getPassengerid() {
		return Passengerid;
	}
	public void setPassengerid(int passengerid) {
		Passengerid = passengerid;
	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
	public int getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Time getDeparturetime() {
//		return departuretime;
//	}
//	public void setDeparturetime(Time departuretime) {
//		this.departuretime = departuretime;
//	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BookReservationInfoBean [regid" + regid + ", flightcode" + flightcode +",passengerid "+Passengerid+",noofseats" +noofseats+",status"+status+",destination"+destination+"]";
	}


}
