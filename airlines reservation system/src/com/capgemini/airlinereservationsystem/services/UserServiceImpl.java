package com.capgemini.airlinereservationsystem.services;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dao.UserDao;
import com.capgemini.airlinereservationsystem.dao.UserDaoImpl;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginInfoBean;

@SuppressWarnings("unused")
public class UserServiceImpl implements UserService {
  private UserDao user=new UserDaoImpl();
	@Override
	public boolean register(UserLoginInfoBean login) {
		
		return user.register(login);
	}

	@Override
	public UserLoginInfoBean authen(String email, String password) {

		return user.authen(email, password);
	}

	

	@Override
	public ArrayList<FlightDetailsInfoBean> getFlightDetails() {
		
		return user.getFlightDetails();
	}

	@Override
	public FlightDetailsInfoBean searchFlightBySource(String source) {
		
		return user.searchFlightBySource(source);
	}

	@Override
	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
		
		return user.searchFlightByDestination(destination);
	}

	@Override
	public FlightDetailsInfoBean searchFlightBycode(String code) {
		
		return user.searchFlightBycode(code);
	}

	@Override
	public boolean Ticketbooking(PassengerDetailsInfoBean bean) {
		
		return user.Ticketbooking(bean);
	}

	
	

}
