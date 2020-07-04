package com.javafsfeb.airlinereservationwithjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.javafsfeb.airlinereservationwithjdbc.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithjdbc.dto.RegistrationIfoBean;
import com.javafsfeb.airlinereservationwithjdbc.exception.AirlineException;
import com.javafsfeb.airlinereservationwithjdbc.utility.Utility;


public class AdminDaoImpl implements AdminDao {

	Utility  jdbc=new Utility();
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	public boolean register(RegistrationIfoBean login) {

		try (Connection connection =jdbc.getConnection()){
			try (PreparedStatement preparedstatement = connection.prepareStatement(jdbc.getQuery("addUser"))){
			
			preparedstatement.setInt(1, login.getRegid());
			preparedstatement.setString(2, login.getName());
			preparedstatement.setLong(3, login.getMobilenumber());
			preparedstatement.setString(4, login.getEmailId());
			preparedstatement.setString(5, login.getPassword());
		    
			preparedstatement.setString(6,login.getRole());

			int count = preparedstatement.executeUpdate();
			if ((login.getEmailId().isEmpty()) && (count == 0)) {
				return false;
			} else {
				return true;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public RegistrationIfoBean authentication(String email, String password) {

		try(Connection connection =jdbc.getConnection()) {
			try(PreparedStatement preparedstatement =connection.prepareStatement(jdbc.getQuery("loginCheck"));){
			
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, password);
			try(ResultSet resultset = preparedstatement.executeQuery()){
			if (resultset.next()) {
				RegistrationIfoBean bean = new RegistrationIfoBean();
				bean.setEmailId(resultset.getString("emailId"));
				bean.setPassword(resultset.getString("password"));
				bean.setRole(resultset.getString("role"));
				return bean;

			}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		throw new AirlineException("Invalid!!!! deatils");
	}

	int results = 0;

	public boolean addFlight(FlightDetailsInfoBean flight) {
		try(Connection connection =jdbc.getConnection()) {
			try(PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("addFlight"));){
			
		//	FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
			preparedstatement.setInt(1, flight.getFlightcode());
			preparedstatement.setString(2, flight.getFlightname());
			preparedstatement.setString(3, flight.getSource());
			preparedstatement.setString(4, flight.getDestination());
			preparedstatement.setTime(5,java.sql.Time.valueOf(flight.getArrival_time()));
			preparedstatement.setTime(6,java.sql.Time.valueOf(flight.getDeparture_time()));
			preparedstatement.setDate(7,java.sql.Date.valueOf(flight.getArrivalDate()));
			preparedstatement.setDate(8,java.sql.Date.valueOf(flight.getDeparturedate()));
			
			results = preparedstatement.executeUpdate();
		
			if (results != 0) {
				return true;
			} else {
				return false;
			}
			}
		} catch (Exception e) {

		} 
//		if (results != 0) {
//			return true;
//		} else {
//			return false;
//		}
		return false;
	}

	public boolean removeFlight(String flightcode) {

		
		FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
		try(Connection connection =jdbc.getConnection()) {
			try(PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("removeFlight"));	){
			
			preparedstatement.setString(1, flightcode);
			int results = preparedstatement.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return true;
	}

	public FlightDetailsInfoBean searchFlightBySource(String source) {

	
		FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
		try(Connection connection =jdbc.getConnection()) {
			try(PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("searchFlightBysource"));	){
			

			preparedstatement.setString(1, source);
			resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				bean.setFlightcode(resultset.getInt("fcode"));
				bean.setFlightname(resultset.getString("flightname"));
				bean.setSource(resultset.getString("source"));
				bean.setDestination(resultset.getString("destination"));
				bean.setArrival_time(resultset.getTime("arrivaltime").toLocalTime());
				bean.setDeparture_time(resultset.getTime("departuretime").toLocalTime());
				bean.setArrivalDate(resultset.getDate("arrivadate").toLocalDate());
				bean.setDeparturedate(resultset.getDate("departuredate").toLocalDate());
			} else {
				System.out.println("not found");
			}
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return bean;
	}// end of retriving method

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
		
		FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
		try(Connection connection =jdbc.getConnection()) {
			try(PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("serachFlightByDestination"));){
			

			preparedstatement.setString(1, destination);
			resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				bean.setFlightcode(resultset.getInt("fcode"));
				bean.setFlightname(resultset.getString("flightname"));
				bean.setSource(resultset.getString("source"));
				bean.setDestination(resultset.getString("destination"));
				bean.setArrival_time(resultset.getTime("arrivaltime").toLocalTime());
				bean.setDeparture_time(resultset.getTime("departuretime").toLocalTime());
				bean.setArrivalDate(resultset.getDate("arrivadate").toLocalDate());
				bean.setDeparturedate(resultset.getDate("departuredate").toLocalDate());
			} else {
				System.out.println("not found");
			}
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return bean;
	}// end of retriving method

	public FlightDetailsInfoBean searchFlightBycode(String code) {
		
		FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
		try(Connection connection =jdbc.getConnection()) {
			try( PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("searchFlightByCode"));){
				
			preparedstatement.setString(1, code);
			resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				bean.setFlightcode(resultset.getInt("fcode"));
				bean.setFlightname(resultset.getString("flightname"));
				bean.setSource(resultset.getString("source"));
				bean.setDestination(resultset.getString("destination"));
				bean.setArrival_time(resultset.getTime("arrivaltime").toLocalTime());
				bean.setDeparture_time(resultset.getTime("departuretime").toLocalTime());
				bean.setArrivalDate(resultset.getDate("arrivadate").toLocalDate());
				bean.setDeparturedate(resultset.getDate("departuredate").toLocalDate());
				

			} else {
				System.out.println("not found");
			}
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return bean;
	}// end of retriving method

	public List<FlightDetailsInfoBean> getFlightDetails() {
		List<FlightDetailsInfoBean> list = new LinkedList<FlightDetailsInfoBean>();

		try(Connection connection =jdbc.getConnection()) {
			try(PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("getAllFlightDetails"));){
			
			resultset = preparedstatement.executeQuery();
			
			while (resultset.next()) {
				FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
				bean.setFlightcode(resultset.getInt("fcode"));
				bean.setFlightname(resultset.getString("flightname"));
				bean.setSource(resultset.getString("source"));
				bean.setDestination(resultset.getString("destination"));
				bean.setArrival_time(resultset.getTime("arrivaltime").toLocalTime());
				bean.setDeparture_time(resultset.getTime("departuretime").toLocalTime());
				bean.setArrivalDate(resultset.getDate("arrivadate").toLocalDate());
				bean.setDeparturedate(resultset.getDate("departuredate").toLocalDate());
				list.add(bean);
			}
			
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<BookReservationInfoBean> showReservations() {

		try(Connection connection =jdbc.getConnection()) {
			try (PreparedStatement preparedstatement=connection.prepareStatement(jdbc.getQuery("showreservations"));	){
			
			
			resultset = preparedstatement.executeQuery();

			LinkedList<BookReservationInfoBean> beans = new LinkedList<BookReservationInfoBean>();
			while (resultset.next()) {
				BookReservationInfoBean bean = new BookReservationInfoBean();
				FlightDetailsInfoBean flightbean=new FlightDetailsInfoBean();
				
				bean.setNoofseats(resultset.getInt("noof_seats"));
				bean.setPassportno(resultset.getString("passport_number"));
				bean.setVisano(resultset.getInt("visa_number"));
				beans.add(bean);
			}
			return beans;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookReservationInfoBean>();
		}
	}
}
