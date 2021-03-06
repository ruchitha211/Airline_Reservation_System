package com.javafsfeb.airlinereservationwithjdbc.dao;

import java.util.List;

import com.javafsfeb.airlinereservationwithjdbc.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.RegistrationIfoBean;


public interface UserDao {

	boolean register(RegistrationIfoBean login);

	RegistrationIfoBean authentication(String email, String password);

	FlightDetailsInfoBean booking(String source, String destination);

	List<FlightDetailsInfoBean> getFlightDetails();

	FlightDetailsInfoBean searchFlightByDestination(String destination);

	boolean cancellation(int personid);

	BookReservationInfoBean ticket(RegistrationIfoBean userBean, FlightDetailsInfoBean flightBean);
	

	  public  BookReservationInfoBean bookFlight(BookReservationInfoBean flightbooking);
  


 FlightDetailsInfoBean searchFlightBySource(String source);
}
// boolean ticketbooking(PassengerDetailsInfoBean bean);