package com.javafsfeb.airlinereservationsystemwithspring.services;


import java.util.List;

import com.javafsfeb.airlinereservationsystemwithspring.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationsystemwithspring.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationsystemwithspring.dto.RegistrationIfoBean;

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
