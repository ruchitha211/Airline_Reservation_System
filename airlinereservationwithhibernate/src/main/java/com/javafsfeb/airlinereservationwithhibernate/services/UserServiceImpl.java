package com.javafsfeb.airlinereservationwithhibernate.services;


import java.util.List;

import com.javafsfeb.airlinereservationwithhibernate.dao.UserDao;
import com.javafsfeb.airlinereservationwithhibernate.dao.UserDaoImpl;
import com.javafsfeb.airlinereservationwithhibernate.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.RegistrationIfoBean;
import com.javafsfeb.airlinereservationwithhibernate.exception.AirlineException;
import com.javafsfeb.airlinereservationwithhibernate.util.Validations;


public class UserServiceImpl implements UserService {

	UserDao user = new UserDaoImpl();
	Validations validation = new Validations();
	boolean flag = false;

	public boolean register(RegistrationIfoBean login) {

		if (validation.validatedId(login.getRegid())) {
			if (validation.validatedName(login.getName())) {
				if (validation.validatedMobile(login.getMobilenumber())) {
					if (validation.validatedEmail(login.getEmailId())) {
						if (validation.validatedPassword(login.getPassword())) {
							if (login.getRole() != null) {
								return user.register(login);
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
				return user.authentication(email, password);
			}
		}
	throw new AirlineException("Please Enter proper details");
		
	}

	public FlightDetailsInfoBean booking(String source, String destination) {

		return user.booking(source, destination);
	}

	public FlightDetailsInfoBean searchFlightBySource(String source) {

		return user.searchFlightBySource(source);
	}

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {

		return user.searchFlightByDestination(destination);
	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		return user.getFlightDetails();
	}

	public boolean cancellation(int personid) {

		return user.cancellation(personid);
	}

	public BookReservationInfoBean ticket(RegistrationIfoBean userBean, FlightDetailsInfoBean flightBean) {

		return user.ticket(userBean, flightBean);
	}

	@Override
	public BookReservationInfoBean bookflight(BookReservationInfoBean flightbooking) {
		
		return user.bookflight(flightbooking);
	}

}
