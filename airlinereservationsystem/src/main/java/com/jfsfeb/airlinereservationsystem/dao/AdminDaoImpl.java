package com.jfsfeb.airlinereservationsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.exception.AirlineException;
import com.jfsfeb.airlinereservationsystem.repository.AirlineDataBase;

public class AdminDaoImpl implements AdminDao {

	public boolean register(AdminLoginInfoBean login) {

		for (AdminLoginInfoBean adminbean : AirlineDataBase.ADMININFO) {
			if (adminbean.getEmailId().equals(login.getEmailId())) {

				return false;
			}
		}

		AirlineDataBase.ADMININFO.add(login);
		return true;
	}

	public AdminLoginInfoBean authentication(String email, String password) {

		for (AdminLoginInfoBean bean : AirlineDataBase.ADMININFO) {
			if (bean.getEmailId().equals(email) && bean.getPassword().equals(password) ) {
				return bean;
		}
		}
		throw new AirlineException("invalid username and password");
		

	}

	public boolean addFlight(FlightDetailsInfoBean flight) {

		for (FlightDetailsInfoBean beans : AirlineDataBase.FLIGHTINFO) {
			if (beans.getFlightcode() == flight.getFlightcode()) {
				return false;
			}
		}
		AirlineDataBase.FLIGHTINFO.add(flight);
		return true;
	}

	public boolean removeFlight(String flightcode) {

		for (FlightDetailsInfoBean bean4 : AirlineDataBase.FLIGHTINFO) {
			if (bean4.getFlightcode() == flightcode) {
				AirlineDataBase.FLIGHTINFO.remove(bean4);
				return true;
			}
		}
		throw new AirlineException("Flight Details are not removed");
	}

	

	public FlightDetailsInfoBean searchFlightBySource(String source) {

		// AdminService bysourse=new AdminServiceImpl();
		for (FlightDetailsInfoBean sour : AirlineDataBase.FLIGHTINFO) {
			if (sour.getSource().equals(source)) {
				return sour;
			}

		}
		return null;
	}

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {

		// AdminService bydest=new AdminServiceImpl();
		for (FlightDetailsInfoBean dest : AirlineDataBase.FLIGHTINFO) {
			if (dest.getDestination().equals(destination)) {
				return dest;
			}
		}

		return null;
	}

	public FlightDetailsInfoBean searchFlightBycode(String code) {

		// AdminService bycode=new AdminServiceImpl();
		for (FlightDetailsInfoBean code1 : AirlineDataBase.FLIGHTINFO) {
			if (code1.getFlightcode().equals(code)) {
				return code1;
			}
		}

		return null;
	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		return AirlineDataBase.FLIGHTINFO;
	}

	public List<BookReservationInfoBean> showReservations() {

		List<BookReservationInfoBean> info = new LinkedList<BookReservationInfoBean>();
		for (BookReservationInfoBean reservationInfo : AirlineDataBase.BOOKINGINFO) {

			reservationInfo.getNoofseats();
			
			info.add(reservationInfo);
		}
		return info;
	}
}

