package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginInfoBean;

public interface UserDao {
	
	boolean register(UserLoginInfoBean login);
	UserLoginInfoBean authen(String email,String password);
	FlightDetailsInfoBean searchFlightBySource(String source);
	FlightDetailsInfoBean searchFlightByDestination(String destination);
	FlightDetailsInfoBean searchFlightBycode(String code);
	ArrayList<FlightDetailsInfoBean> getFlightDetails();
    boolean Ticketbooking(PassengerDetailsInfoBean bean);
 
}
