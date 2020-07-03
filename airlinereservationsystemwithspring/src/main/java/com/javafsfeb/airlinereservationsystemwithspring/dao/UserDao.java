package com.javafsfeb.airlinereservationsystemwithspring.dao;

import java.util.List;

import com.javafsfeb.airlinereservationsystemwithspring.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationsystemwithspring.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationsystemwithspring.dto.RegistrationIfoBean;



public interface UserDao {

	boolean register(RegistrationIfoBean login);

	RegistrationIfoBean authentication(String email, String password);

	FlightDetailsInfoBean booking(String source, String destination);

	List<FlightDetailsInfoBean> getFlightDetails();

	FlightDetailsInfoBean searchFlightByDestination(String destination);

	boolean cancellation(int personid);

	BookReservationInfoBean ticket(RegistrationIfoBean userBean, FlightDetailsInfoBean flightBean);

  public  BookReservationInfoBean bookflight(BookReservationInfoBean flightbooking);
  
 FlightDetailsInfoBean searchFlightBySource(String source);
}
