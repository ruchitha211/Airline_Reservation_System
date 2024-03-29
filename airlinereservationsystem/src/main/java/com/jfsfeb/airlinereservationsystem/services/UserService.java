package com.jfsfeb.airlinereservationsystem.services;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.UserLoginInfoBean;

public interface UserService {

	boolean register(UserLoginInfoBean login);

	UserLoginInfoBean authentication(String email, String password);

	FlightDetailsInfoBean booking(String source, String destination);

	FlightDetailsInfoBean searchFlightBySource(String source);

	FlightDetailsInfoBean searchFlightByDestination(String destination);

	// FlightDetailsInfoBean searchFlightBycode(String code);
	List<FlightDetailsInfoBean> getFlightDetails();

	boolean cancellation(int personid);

	BookReservationInfoBean ticket(UserLoginInfoBean userBean, FlightDetailsInfoBean flightBean);
}
