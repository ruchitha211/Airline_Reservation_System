package com.jfsfeb.airlinereservationsystem.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.UserLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.exception.AirlineException;
import com.jfsfeb.airlinereservationsystem.repository.AirlineDataBase;

public class UserDaoImpl implements UserDao {

	public boolean register(UserLoginInfoBean login) {

		for (UserLoginInfoBean userbean : AirlineDataBase.USERINFO) {
			if (userbean.getEmailId().equals(login.getEmailId())) {
				return false;
			}

		}
		AirlineDataBase.USERINFO.add(login);
		return true;
	}

	public UserLoginInfoBean authentication(String email, String password) {

		for (UserLoginInfoBean bean : AirlineDataBase.USERINFO) {
			if (bean.getEmailId().equals(email) && bean.getPassword().equals(password)) {
				
				return bean;
			}
			
				 
			}
		
		throw new AirlineException("invalid username and password");

	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		return AirlineDataBase.FLIGHTINFO;
	}

	public FlightDetailsInfoBean searchFlightBySource(String source) {
		// UserService bysourse = new UserServiceImpl();
		for (FlightDetailsInfoBean sour : AirlineDataBase.FLIGHTINFO) {
			if (sour.getSource().equals(source)) {
				return sour;
			}

		}
		return null;
	}

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
		// UserService bysourse = new UserServiceImpl();
		for (FlightDetailsInfoBean dest : AirlineDataBase.FLIGHTINFO) {
			if (dest.getDestination().equals(destination)) {
				return dest;
			}
		}

		return null;
	}

	public boolean cancellation(int personid) {
		for (UserLoginInfoBean bean4 : AirlineDataBase.USERINFO) {
			if (bean4.getRegId() == personid) {
				AirlineDataBase.USERINFO.remove(bean4);
				return true;
			}
		}
		throw new AirlineException("Ticket is not cancelled");
	}

	public FlightDetailsInfoBean booking(String source, String destination) {

		for (FlightDetailsInfoBean bean : AirlineDataBase.FLIGHTINFO) {
			if ((bean.getSource().equalsIgnoreCase(source)) && (bean.getDestination().equalsIgnoreCase(destination))) {

				return bean;
			}

		}
		throw new AirlineException("No flights are available");

	}

	public BookReservationInfoBean ticket(UserLoginInfoBean userBean, FlightDetailsInfoBean flightBean) {
		boolean flag = false, isRequestExists = false;
		BookReservationInfoBean requestInfo = new BookReservationInfoBean();
		UserLoginInfoBean userInfo2 = new UserLoginInfoBean();
		FlightDetailsInfoBean bookInfo2 = new FlightDetailsInfoBean();

		for (BookReservationInfoBean requestInfo2 : AirlineDataBase.BOOKINGINFO) {
			if (flightBean.getFlightcode().equals(requestInfo2.getFbean().getFlightcode())) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (UserLoginInfoBean user1 : AirlineDataBase.USERINFO) {
				if (userBean.getRegId() == user1.getRegId()) {
					for (FlightDetailsInfoBean flight1 : AirlineDataBase.FLIGHTINFO) {
						if (flight1.getFlightcode().equals(flightBean.getFlightcode())) {
							userInfo2 = user1;
							bookInfo2 = flight1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setFbean(bookInfo2);
				requestInfo.setUser(userInfo2);
	
				AirlineDataBase.BOOKINGINFO.add(requestInfo);
				return requestInfo;
			}

		}

		throw new AirlineException("Invalid request or you cannot request that Flight");
	}

}

// public FlightDetailsInfoBean searchFlightBycode(String code) {
// UserService bysourse=new UserServiceImpl();
// for(FlightDetailsInfoBean code1:AirlineDataBase.dataBase()) {
// if(code1.getFlightcode().equals(code)) {
// return code1;
// }
// }
// public boolean ticketbooking(PassengerDetailsInfoBean bean) {
//
// for(PassengerDetailsInfoBean bean3:AirlineDataBase.passdetails()) {
//
// return AirlineDataBase.passdetails().add(bean3);
//
// }
// return false;
//
// }

// return null;
// }
