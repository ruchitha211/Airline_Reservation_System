package com.capgemini.airlinereservationsystem.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;

public interface AdminService {
	
	boolean register(AdminLoginInfoBean login);
	AdminLoginInfoBean authen(String email,String password);
	boolean addflight(FlightDetailsInfoBean flight);
	boolean removeflight(String fcode);

	FlightDetailsInfoBean searchFlightBySource(String source);
	FlightDetailsInfoBean searchFlightByDestination(String destination);
	FlightDetailsInfoBean searchFlightBycode(String code);
	ArrayList<FlightDetailsInfoBean> getFlightDetails();
	List<BookReservationInfoBean> showReservations();
	


}
