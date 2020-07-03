package com.javafsfeb.airlinereservationsystemwithspring.dto;

import java.io.Serializable;

import java.time.LocalDate;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="flightdetails")
public class FlightDetailsInfoBean implements Serializable {

	@Id
	@Column(name="fcode")
	private int flightcode;
	@Column
	private String flightname;
	@Column
	private String source;
	@Column
	private String destination;
	@Column(name="depaturetime")
	private LocalTime departure_time;
	@Column(name="arrivaltime")
	private LocalTime arrival_time;
	@Column(name="arrivadate")
	private LocalDate arrivalDate;
	@Column
	private LocalDate departuredate;

}
