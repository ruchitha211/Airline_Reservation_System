package com.capgemini.airlinereservationsystem.services;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginInfoBean;

public interface UserService{
	
	boolean register(UserLoginInfoBean login);
	UserLoginInfoBean authen(String email,String password);
	FlightDetailsInfoBean searchFlightBySource(String source);
	FlightDetailsInfoBean searchFlightByDestination(String destination);
	FlightDetailsInfoBean searchFlightBycode(String code);
	ArrayList<FlightDetailsInfoBean> getFlightDetails();
	 boolean ticketbooking(PassengerDetailsInfoBean bean);
	 boolean cancellation(int pid);

}
		
