package com.jfsfeb.airlinereservationsystem.repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.UserLoginInfoBean;

public class AirlineDataBase {

	public static final List<AdminLoginInfoBean> ADMININFO = new ArrayList<AdminLoginInfoBean>();
	public static final List<UserLoginInfoBean> USERINFO = new ArrayList<UserLoginInfoBean>();
	public static final List<FlightDetailsInfoBean> FLIGHTINFO = new ArrayList<FlightDetailsInfoBean>();
	public static final List<BookReservationInfoBean> BOOKINGINFO = new ArrayList<BookReservationInfoBean>();
	public static final List<PassengerDetailsInfoBean> PASSENGERINFO = new ArrayList<PassengerDetailsInfoBean>();

	public static void details() {
		
		AdminLoginInfoBean admin=new AdminLoginInfoBean();
		admin.setAdminId(20002);
		admin.setUserName("Ruchitha");
		admin.setEmailId("ruchitha@gmail.com");
		admin.setPassword("Ruchi@123");
		admin.setMobileNumber(9989029855L);
		ADMININFO.add(admin);
		
		UserLoginInfoBean user=new UserLoginInfoBean();
		user.setRegId(10001);
		user.setUserName("User");
		user.setEmailId("user@gmail.com");
		user.setPassword("User@123");
		user.setMobileNumber(7702308564L);
		USERINFO.add(user);

        FlightDetailsInfoBean flight=new FlightDetailsInfoBean();
        flight.setFlightcode("ABCHYD");
        flight.setFlightname("Indigo");
        flight.setSource("Hyderabad");
        flight.setDestination( "Banglore");
        flight.setArrival_time(LocalDateTime.of(2020, Month.APRIL, 4, 5, 10));
        flight.setDeparture_time( LocalDateTime.of(2020, Month.APRIL, 4, 7, 20));
        FLIGHTINFO.add(flight);
        
        FlightDetailsInfoBean flight1=new FlightDetailsInfoBean();
        flight1.setFlightcode("CDEBNG");
        flight1.setFlightname("Jet");
        flight1.setSource("Banglore");
        flight1.setDestination( "Hyderabad");
        flight1.setArrival_time(LocalDateTime.of(2020, Month.APRIL, 5, 5, 10));
        flight1.setDeparture_time(  LocalDateTime.of(2020, Month.APRIL, 5, 9, 20));
        FLIGHTINFO.add(flight1);
        
        FlightDetailsInfoBean flight2=new FlightDetailsInfoBean();

        flight2.setFlightcode("FGHHYD");
        flight2.setFlightname( "GoAir");
        flight2.setSource("Delhi");
        flight2.setDestination( "Hyderabad");
        flight2.setArrival_time(LocalDateTime.of(2020, Month.APRIL, 5, 5, 10));
        flight2.setDeparture_time( LocalDateTime.of(2020, Month.APRIL, 5, 9, 20));
        FLIGHTINFO.add(flight2);

		BookReservationInfoBean booking=new BookReservationInfoBean();
		
		booking.setFbean(flight);
		booking.setUser(user);
		booking.setPassportno("PS123");
		booking.setNoofseats(4);
		booking.setVisano("VISA12");
	
		
		
	}
}
