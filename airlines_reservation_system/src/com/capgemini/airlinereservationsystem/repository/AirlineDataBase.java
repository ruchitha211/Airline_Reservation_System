package com.capgemini.airlinereservationsystem.repository;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginInfoBean;

public class AirlineDataBase {
	
	public static final ArrayList<AdminLoginInfoBean>  admininfo =new ArrayList<AdminLoginInfoBean>();
	public static final ArrayList<UserLoginInfoBean>    userinfo= new ArrayList<UserLoginInfoBean>();
	public static final ArrayList<FlightDetailsInfoBean>  flightinfo =new ArrayList<FlightDetailsInfoBean>();
	public static final LinkedList<BookReservationInfoBean> bookinginfo=new LinkedList<BookReservationInfoBean>();
	public static final ArrayList<PassengerDetailsInfoBean>   passengerinfo=new ArrayList<PassengerDetailsInfoBean>();
	
	public static ArrayList<AdminLoginInfoBean> dataadmin() {
		
		admininfo.add(new AdminLoginInfoBean("ruchitha@gmail.com","ruchi123"));	
		admininfo.add(new AdminLoginInfoBean("lucky@gmail.com","lucky123"));
		
		return admininfo;	
	}
	public static ArrayList<UserLoginInfoBean> datauser(){
		userinfo.add(new UserLoginInfoBean(10001,"user@gmail.com","user123"));
		
		return userinfo;
	}
	
	public static ArrayList<FlightDetailsInfoBean> dataBase() {
		
		
		flightinfo.add(new FlightDetailsInfoBean("AB123","Indigo","Hyderabad","Banglore",LocalDateTime.of(2020,Month.APRIL, 4, 5, 10)));
		flightinfo.add(new FlightDetailsInfoBean("XYZ123","Jet","Hyderabad","DUBAI",LocalDateTime.of(2020,Month.APRIL, 5, 5, 10)));
		flightinfo.add(new FlightDetailsInfoBean("XYZ123","GoAir","Banglore","Hyderabad",LocalDateTime.of(2020,Month.APRIL, 7, 5, 10)));
		flightinfo.add(new FlightDetailsInfoBean("XYZ123","Indigo","Delhi","Mumbai",LocalDateTime.of(2020,Month.APRIL, 4, 8, 10)));
		flightinfo.add(new FlightDetailsInfoBean("XYZ123","Indigo","Hyderabad","Delhi",LocalDateTime.of(2020,Month.APRIL, 4, 9, 10)));
		
		return flightinfo;
	}
		
	public static LinkedList<BookReservationInfoBean> bookeddata(){	
	
		bookinginfo.add(new BookReservationInfoBean(1,"AB123",101,4,"Booked","Banglore"));
		
		return bookinginfo;
	}
		
   public static ArrayList<PassengerDetailsInfoBean> passdetails(){
	   passengerinfo.add(new PassengerDetailsInfoBean(101,"PS123","VISA20","Hyderabad","Banglore","Ruchitha","Pola","ruchi@gmail.com","NZB",99896578,24,"Female"));
	   return passengerinfo;
   }
		
		
		
	}

	

