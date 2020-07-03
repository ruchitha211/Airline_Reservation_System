package com.jfsfeb.airlinereservationsystem.services;


import java.util.InputMismatchException;
import java.util.List;

import com.jfsfeb.airlinereservationsystem.dao.UserDao;
import com.jfsfeb.airlinereservationsystem.dao.UserDaoImpl;
import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;

import com.jfsfeb.airlinereservationsystem.dto.UserLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.exception.AirlineException;
import com.jfsfeb.airlinereservationsystem.util.Validations;


public class UserServiceImpl implements UserService {
	
	boolean flag=false;
	private UserDao user = new UserDaoImpl();
	Validations validation = new Validations();

	public boolean register(UserLoginInfoBean login) {
		try {
			if (login.getUserName() != null) {
				if (validation.validatedName(login.getUserName()) == true) {
					return true;
				}
			}
			if (login.getRegId() != 0) {
				if (validation.validatedId(login.getRegId()) == true) {
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
					return user.register(login);
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


	public UserLoginInfoBean authentication(String email, String password) {
		if (email != null && password != null) {
			if (validation.validatedEmail(email)) {
				if (validation.validatedPassword(password)) {
					return user.authentication(email, password);
				}
			}
		}
		throw new AirlineException("Enter email and password  correctly");

	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		return user.getFlightDetails();
	}

	public FlightDetailsInfoBean searchFlightBySource(String source) {

		return user.searchFlightBySource(source);
	}

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {

		return user.searchFlightByDestination(destination);
	}

	public boolean cancellation(int personid) {
		if (personid != 0) {
			if (validation.validatedId(personid)) {

				return user.cancellation(personid);
			}

		}
		throw new AirlineException("person id is invalid");
	}

	public FlightDetailsInfoBean booking(String source, String destination) {

		return user.booking(source, destination);
	}

	public BookReservationInfoBean ticket(UserLoginInfoBean userBean, FlightDetailsInfoBean flightBean) {

		return user.ticket(userBean, flightBean);
	}

}
