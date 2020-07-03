package com.javafsfeb.airlinereservationwithhibernate.services;


import java.util.List;

import com.javafsfeb.airlinereservationwithhibernate.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.RegistrationIfoBean;

public interface AdminService {
	
	boolean register(RegistrationIfoBean login);
	RegistrationIfoBean authentication(String email, String password);
	boolean addFlight(FlightDetailsInfoBean flight);
	boolean removeFlight(int flightcode);

	FlightDetailsInfoBean searchFlightBySource(String source);
	FlightDetailsInfoBean searchFlightByDestination(String destination);
	FlightDetailsInfoBean searchFlightBycode(String code);
	List<FlightDetailsInfoBean> getFlightDetails();
	List<BookReservationInfoBean> showReservations();
	
  


}
