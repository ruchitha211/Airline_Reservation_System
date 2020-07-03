package com.javafsfeb.airlinereservationwithjdbc.services;


import java.util.List;


import com.javafsfeb.airlinereservationwithjdbc.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.RegistrationIfoBean;


public interface AdminService {
	
	boolean register(RegistrationIfoBean login);
	RegistrationIfoBean authentication(String email, String password);
	boolean addFlight(FlightDetailsInfoBean flight);
	boolean removeFlight(String flightcode);

	FlightDetailsInfoBean searchFlightBySource(String source);
	FlightDetailsInfoBean searchFlightByDestination(String destination);
	FlightDetailsInfoBean searchFlightBycode(String code);
	List<FlightDetailsInfoBean> getFlightDetails();
	List<BookReservationInfoBean> showReservations();
  


}
