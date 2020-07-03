package com.javafsfeb.airlinereservationwithhibernate.services;

import java.util.List;

import com.javafsfeb.airlinereservationwithhibernate.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.RegistrationIfoBean;


public interface UserService {

	boolean register(RegistrationIfoBean login);

	RegistrationIfoBean authentication(String email, String password);

	FlightDetailsInfoBean booking(String source, String destination);

	FlightDetailsInfoBean searchFlightBySource(String source);

	FlightDetailsInfoBean searchFlightByDestination(String destination);
	

 public  BookReservationInfoBean bookflight(BookReservationInfoBean flightbooking);

	
	List<FlightDetailsInfoBean> getFlightDetails();

	boolean cancellation(int personid);

	BookReservationInfoBean ticket(RegistrationIfoBean userBean, FlightDetailsInfoBean flightBean);
}
