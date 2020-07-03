package com.capgemini.airlinereservationsystem.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.airlinereservationsystem.dao.AdminDao;
import com.capgemini.airlinereservationsystem.dao.AdminDaoImpl;
import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao admin=new AdminDaoImpl();

	@Override
	public boolean register(AdminLoginInfoBean login) {
		
		return admin.register(login);
	}

	@Override
	public AdminLoginInfoBean authen(String email, String password) {
		
		return admin.authen(email, password);
	}

	@Override
	public boolean addflight(FlightDetailsInfoBean flight) {
	
		return admin.addflight(flight);
	}

	@Override
	public boolean removeflight(String flightcode) {

		return admin.removeflight(flightcode);
	}

//	@Override
//	public ArrayList<FlightDetailsInfoBean> searchFlightBySource(String source) {
//	
//		return admin.searchFlightBySource(source);
//	}

//	@Override
//	public ArrayList<FlightDetailsInfoBean> searchFlightByDestination(String destination) {
//
//		return admin.searchFlightByDestination(destination);
//	}
//
//	@Override
//	public ArrayList<FlightDetailsInfoBean> searchFlightBycode(String code) {
//		
//		return admin.searchFlightBycode(code);
//	}

	@Override
	public ArrayList<FlightDetailsInfoBean> getFlightDetails() {
	
		return admin.getFlightDetails();
	}

	@Override
	public List<BookReservationInfoBean> showReservations() {
	
		return admin.showReservations();
	}

	@Override
	public FlightDetailsInfoBean searchFlightBySource(String source) {
		
		return admin.searchFlightBySource(source);
	}

	@Override
	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
	
		return admin.searchFlightByDestination(destination);
	}

	@Override
	public FlightDetailsInfoBean searchFlightBycode(String code) {
		
		return admin.searchFlightBycode(code);
	}

}
