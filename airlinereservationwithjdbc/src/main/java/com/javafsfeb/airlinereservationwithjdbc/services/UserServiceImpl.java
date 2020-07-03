package com.javafsfeb.airlinereservationwithjdbc.services;


import java.util.List;

import com.javafsfeb.airlinereservationwithjdbc.dao.UserDao;
import com.javafsfeb.airlinereservationwithjdbc.dao.UserDaoImpl;
import com.javafsfeb.airlinereservationwithjdbc.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.RegistrationIfoBean;
import com.javafsfeb.airlinereservationwithjdbc.exception.AirlineException;
import com.javafsfeb.airlinereservationwithjdbc.util.Validations;

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
		if((email!=null) && (password!=null)) {
		if(validation.validatedEmail(email)) {
			if(validation.validatedPassword(password)) {
				return user.authentication(email, password);
			}
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
		if(validation.validatedId(personid)){
			return user.cancellation(personid);
		}

		throw new AirlineException("Please Enter proper details it should contain 5 digits");
	}

	public BookReservationInfoBean ticket(RegistrationIfoBean userBean, FlightDetailsInfoBean flightBean) {

		return user.ticket(userBean, flightBean);
	}

	@Override
	public BookReservationInfoBean bookFlight(BookReservationInfoBean flightbooking) {
//		if(flightbooking.getFlightcode()!=0) {
//			if(validation.validatedId(flightbooking.getId())) {
//				if(validation.isValidPassportNo(flightbooking.getPassportno())) {
//					if(flightbooking.getNoofseats()!=0) {
//						if(validation.isValidVisaCardNo(flightbooking.getVisano())) {
							return user.bookFlight(flightbooking);
							
//						}
//					}
//				}
//			}
//			
//		}
//		
//		throw new AirlineException("Please Enter proper details");
}

}
