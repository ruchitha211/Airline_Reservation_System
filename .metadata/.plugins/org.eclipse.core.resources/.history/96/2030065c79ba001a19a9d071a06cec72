package com.jfsfeb.airlinereservationsystem.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;

public interface AdminDao {

	boolean register(AdminLoginInfoBean login);

	AdminLoginInfoBean authentication(String email, String password);

	boolean addFlight(FlightDetailsInfoBean flight);

	boolean removeFlight(String flightcode);

	FlightDetailsInfoBean searchFlightBySource(String source);

	FlightDetailsInfoBean searchFlightByDestination(String destination);

	FlightDetailsInfoBean searchFlightBycode(String code);

	List<FlightDetailsInfoBean> getFlightDetails();

	List<BookReservationInfoBean> showReservations();
	 
	

}
