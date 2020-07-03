package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;

import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginInfoBean;
import com.capgemini.airlinereservationsystem.exception.AirlineException;
import com.capgemini.airlinereservationsystem.repository.AirlineDataBase;
import com.capgemini.airlinereservationsystem.services.AdminService;
import com.capgemini.airlinereservationsystem.services.AdminServiceImpl;
import com.capgemini.airlinereservationsystem.services.UserService;
import com.capgemini.airlinereservationsystem.services.UserServiceImpl;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean register(UserLoginInfoBean login) {
		
		for (UserLoginInfoBean userbean : AirlineDataBase.datauser()) {
			if (userbean.getUsername().equals(login.getUsername())) {
				return false;
			}

		}
		AirlineDataBase.datauser().add(login);
		return true;
	}

	@Override
	public UserLoginInfoBean authen(String username, String password) {
	
		for(UserLoginInfoBean bean:AirlineDataBase.datauser()) {
			if(bean.getUsername().equals(username)&&bean.getPassword().equals(password)) {
				System.out.println("login successful");
				return bean;
			}
			throw new AirlineException("invalid username and password");
		}
		
		return null;
	}

	
	
	public ArrayList<FlightDetailsInfoBean> getFlightDetails() {
		
		return AirlineDataBase.dataBase();
	}

	@Override
	public FlightDetailsInfoBean searchFlightBySource(String source) {
		UserService bysourse=new UserServiceImpl();
		  for(FlightDetailsInfoBean sour: AirlineDataBase.dataBase()) {
			  if(sour.getSource().equals(source)) {
				  return sour;
			  }
		  
			
		
		}
		return null;
	}

	@Override
	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
		UserService bysourse=new UserServiceImpl();
		for(FlightDetailsInfoBean dest: AirlineDataBase.dataBase()) {
			if(dest.getDestination().equals(destination)) {
				return dest;
		}
		}
	
		return null;
	}

	@Override
	public FlightDetailsInfoBean searchFlightBycode(String code) {
		UserService bysourse=new UserServiceImpl();
		for(FlightDetailsInfoBean code1:AirlineDataBase.dataBase()) {
			if(code1.getFlightcode().equals(code)) {
				return code1;
			}
		}
		return null;
	}

	@Override
	public boolean Ticketbooking(PassengerDetailsInfoBean bean) {
		
		for(PassengerDetailsInfoBean bean3:AirlineDataBase.passdetails()) {
	
		return AirlineDataBase.passdetails().add(bean3);
		
	}
		return false;

	}

//	@Override
//	public boolean cancellation(int cancel) {
//	    for(PassengerDetailsInfoBean bean4:AirlineDataBase.passdetails()) {
//	    	if(bean4.getPassengerid()==cancel.ge()){
//	    		return true;
//	    		
//	    	}
//	    	
//	    }  
//		return false;
//	}

}
