package com.javafsfeb.airlinereservationwithhibernate.services;

import java.util.List;

import com.javafsfeb.airlinereservationwithhibernate.dao.AdminDao;
import com.javafsfeb.airlinereservationwithhibernate.dao.AdminDaoImpl;
import com.javafsfeb.airlinereservationwithhibernate.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.RegistrationIfoBean;
import com.javafsfeb.airlinereservationwithhibernate.exception.AirlineException;
import com.javafsfeb.airlinereservationwithhibernate.util.Validations;


public class AdminServiceImpl implements AdminService {
	
	AdminDao admin=new AdminDaoImpl();
	Validations validation=new Validations();

	public boolean register(RegistrationIfoBean login) {

		if (validation.validatedId(login.getRegid())) {
			if (validation.validatedName(login.getName())) {
				if (validation.validatedMobile(login.getMobilenumber())) {
					if (validation.validatedEmail(login.getEmailId())) {
						if (validation.validatedPassword(login.getPassword())) {
							if (login.getRole() != null) {
								return admin.register(login);
							}
						}
					}
				}
			}
		}

		throw new AirlineException("Enter correct details");
	}


	public RegistrationIfoBean authentication(String email, String password) {
		if(validation.validatedEmail(email)) {
			if(validation.validatedPassword(password)) {
				return admin.authentication(email, password);
			}
		}
	throw new AirlineException("Please Enter proper details");
		
	}

	public boolean addFlight(FlightDetailsInfoBean flight) {
	
		return admin.addFlight(flight);
	}


	public FlightDetailsInfoBean searchFlightBySource(String source) {

		return admin.searchFlightBySource(source);
	}

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
		
		return admin.searchFlightByDestination(destination);
	}

	public FlightDetailsInfoBean searchFlightBycode(String code) {
		
		return admin.searchFlightBycode(code);
	}

	public List<FlightDetailsInfoBean> getFlightDetails() {
		
		return admin.getFlightDetails();
	}

	public List<BookReservationInfoBean> showReservations() {
		
		return admin.showReservations();
	}


	@Override
	public boolean removeFlight(int flightcode) {
		
		return admin.removeFlight(flightcode);
	}


	

	
	
}