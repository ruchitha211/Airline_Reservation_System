package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;

public interface AdminDao {
	
	boolean register(AdminLoginInfoBean login);
	AdminLoginInfoBean authen(String email,String password);
	boolean addflight(FlightDetailsInfoBean flight);
	boolean removeflight(String flightcode);
	
	FlightDetailsInfoBean searchFlightBySource(String source);
	
	FlightDetailsInfoBean searchFlightByDestination(String destination);
	FlightDetailsInfoBean searchFlightBycode(String code);
	ArrayList<FlightDetailsInfoBean> getFlightDetails();
	List<BookReservationInfoBean> showReservations();
	

}
