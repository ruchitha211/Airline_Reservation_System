package com.jfsfeb.airlinereservationsystem.services;

import java.util.InputMismatchException;
import java.util.List;

import com.jfsfeb.airlinereservationsystem.dao.AdminDao;
import com.jfsfeb.airlinereservationsystem.dao.AdminDaoImpl;
import com.jfsfeb.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.exception.AirlineException;
import com.jfsfeb.airlinereservationsystem.util.Validations;

public class AdminServiceImpl implements AdminService {

	boolean flag = false;
	private AdminDao admin = new AdminDaoImpl();
	Validations validation = new Validations();

	public boolean register(AdminLoginInfoBean login) {

		try {
			if (login.getUserName() != null) {
				if (validation.validatedName(login.getUserName()) == true) {
					return true;
				}
			}
			if (login.getAdminId() != 0) {
				if (validation.validatedId(login.getAdminId()) == true) {
					return true;
				}
			}
			if (login.getMobileNumber() != null) {
				if (validation.validatedMobile(login.getMobileNumber()) == true) {
					return true;
				}
			}
			if (login.getEmailId() != null) {
				if (validation.validatedEmail(login.getEmailId()) == true) {
					return admin.register(login);
				}
			}
			if (login.getPassword() != null) {
				if (validation.validatedPassword(login.getPassword()) == true) {
					return true;
				}
			}
		} catch (InputMismatchException e) {
			flag = false;

		} catch (AirlineException e) {
			flag = false;
			System.err.println(e.getMessage());
		}
		return false;
	}

	public AdminLoginInfoBean authentication(String email, String password) {
		if (email != null && password != null) {
			if (validation.validatedEmail(email)) {
				if (validation.validatedPassword(password)) {
					return admin.authentication(email, password);
				}
			}
		}
		throw new AirlineException("Enter email and password  correctly");
	}

	public boolean addFlight(FlightDetailsInfoBean flight) {
		try {
			if (flight.getFlightcode() != null) {
				if (validation.validatedName(flight.getFlightcode()) == true) {
					return true;
				}
			}
			if (flight.getFlightname() != null) {
				if (validation.validatedName(flight.getFlightname()) == true) {
					return true;
				}
			}
			if (flight.getSource() != null) {
				if (validation.validatedName(flight.getSource()) == true) {
					return true;
				}
			}
			if (flight.getDestination() != null) {
				if (validation.validatedName(flight.getDestination()) == true) {
					return true;
				}
			}
			if(flight.getArrival_time()!=null) {
				return true;
			}
			if(flight.getDeparture_time()!=null) {
				return admin.addFlight(flight);
			}

		} catch (InputMismatchException e) {
			flag = false;

		} catch (AirlineException e) {
			flag = false;
			System.err.println(e.getMessage());
		}
		return false;
	}
	

	public boolean removeFlight(String flightcode) {

		return admin.removeFlight(flightcode);
	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		return admin.getFlightDetails();
	}

	public List<BookReservationInfoBean> showReservations() {

		return admin.showReservations();
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

}