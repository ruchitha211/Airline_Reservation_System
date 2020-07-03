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

public class UserDaoImpl implements UserDao {

	Utility jdbc = new Utility();
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;

	public boolean register(RegistrationIfoBean login) {
		try (Connection connection = jdbc.getConnection()) {
			try (PreparedStatement preparedstatement = connection.prepareStatement(jdbc.getQuery("addUser"));) {

				preparedstatement.setInt(1, login.getRegid());
				preparedstatement.setString(2, login.getName());
				preparedstatement.setLong(3, login.getMobilenumber());
				preparedstatement.setString(4, login.getEmailId());
				preparedstatement.setString(5, login.getPassword());
				preparedstatement.setString(6, login.getRole());

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

		try (Connection connection = jdbc.getConnection()) {
			try (PreparedStatement preparedstatement = connection.prepareStatement(jdbc.getQuery("loginCheck"));) {

				preparedstatement.setString(1, email);
				preparedstatement.setString(2, password);
				resultset = preparedstatement.executeQuery();
				if (resultset.next()) {
					RegistrationIfoBean bean = new RegistrationIfoBean();

					bean.setEmailId(resultset.getString("emailId"));
					bean.setPassword(resultset.getString("password"));
					bean.setRole(resultset.getString("role"));

					return bean;
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FlightDetailsInfoBean booking(String source, String destination) {

		try (Connection connection = jdbc.getConnection()) {
			try (PreparedStatement preparedstatement = connection
					.prepareStatement(jdbc.getQuery("searchFlightBySourceandDestination"));) {

				preparedstatement.setString(1, source);
				preparedstatement.setString(2, destination);
				resultset = preparedstatement.executeQuery();
				if (resultset.next()) {
					FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
					bean.setFlightcode(resultset.getInt("fcode"));
					bean.setFlightname(resultset.getString("flightname"));
					bean.setSource(resultset.getString("source"));
					bean.setDestination(resultset.getString("destination"));
					bean.setArrival_time(resultset.getTime("arrivaltime").toLocalTime());
					bean.setDeparture_time(resultset.getTime("departuretime").toLocalTime());
					bean.setArrivalDate(resultset.getDate("arrivadate").toLocalDate());
					bean.setDeparturedate(resultset.getDate("departuredate").toLocalDate());

					return bean;
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		List<FlightDetailsInfoBean> list = new LinkedList<FlightDetailsInfoBean>();

		try (Connection connection = jdbc.getConnection()) {
			try (PreparedStatement preparedstatement = connection
					.prepareStatement(jdbc.getQuery("getAllFlightDetails"));) {

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

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {

		FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
		try (Connection connection = jdbc.getConnection()) {
			try (PreparedStatement preparedstatement = connection
					.prepareStatement(jdbc.getQuery("serachFlightByDestination"));) {

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

	public boolean cancellation(int personid) {

		BookReservationInfoBean bean = new BookReservationInfoBean();
		try (Connection connection = jdbc.getConnection()) {
			try(PreparedStatement preparedstatement = connection.prepareStatement(jdbc.getQuery("cancellation"));){
			

			preparedstatement.setInt(1, personid);
			preparedstatement.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return true;
	}

	int results = 0;

	public BookReservationInfoBean ticket(RegistrationIfoBean userBean, FlightDetailsInfoBean flightBean) {
		try {
			FileInputStream fileinput = new FileInputStream("connectioninfo.properties");
			Properties prop = new Properties();
			prop.load(fileinput);
			Class.forName(prop.getProperty("driver")).newInstance();
			connection = DriverManager.getConnection(prop.getProperty("dburl"), prop);
			preparedstatement = connection.prepareStatement("insert into reservations values(?,?,?,?,?)");
			BookReservationInfoBean bean = new BookReservationInfoBean();
			preparedstatement.setInt(1, userBean.getRegid());
			preparedstatement.setInt(2, flightBean.getFlightcode());
			preparedstatement.setInt(3, bean.getNoofseats());
			preparedstatement.setString(4, bean.getPassportno());
			preparedstatement.setString(5, bean.getVisano());

			results = preparedstatement.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}

			} catch (Exception e) {

			}

		}
		return null;

	}

	public FlightDetailsInfoBean searchFlightBySource(String source) {

		FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
		try (Connection connection = jdbc.getConnection()) {
			try (PreparedStatement preparedstatement = connection
					.prepareStatement(jdbc.getQuery("searchFlightBysource"));) {

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

	@Override
	public BookReservationInfoBean bookFlight(BookReservationInfoBean flightbooking) {

		try {
			Connection conn = jdbc.getConnection();
			PreparedStatement getFlightPstmt = conn.prepareStatement(jdbc.getQuery("searchFlightByCode"));

			getFlightPstmt.setInt(1, flightbooking.getFlightcode());

			try (ResultSet getReqSet = getFlightPstmt.executeQuery();) {
				while (getReqSet.next()) {
					int bookFlightId = getReqSet.getInt("fcode");

					if (flightbooking.getFlightcode() == bookFlightId) {

						try {
							Connection conne = jdbc.getConnection();
							PreparedStatement getUserPstmt = conne.prepareStatement(jdbc.getQuery("tocheckId"));
							getUserPstmt.setInt(1, flightbooking.getId());
							try (ResultSet getUser = getUserPstmt.executeQuery();) {
								while (getUser.next()) {
									int user = getUser.getInt("id");

									if (flightbooking.getId() == user) {

										try {
											Connection conn1 = jdbc.getConnection();
											PreparedStatement getRequestPstmt = conn1
													.prepareStatement(jdbc.getQuery("addingDetails"));
											getRequestPstmt.setInt(1, flightbooking.getId());
											getRequestPstmt.setInt(2, flightbooking.getFlightcode());
											getRequestPstmt.setInt(3, flightbooking.getNoofseats());
											getRequestPstmt.setString(4, flightbooking.getPassportno());
											getRequestPstmt.setString(5, flightbooking.getVisano());

											getRequestPstmt.executeUpdate();
											return flightbooking;

										} catch (Exception e) {
											throw new AirlineException("Can't request flight");
										}

									}
								}
							}
						} catch (Exception e) {
							throw new AirlineException(e.getMessage());
						}
					}
				}
			}
		} catch (AirlineException e) {
			throw new AirlineException(e.getMessage());
		} catch (Exception e) {
			throw new AirlineException(e.getMessage());
		}
		return null;
	}
	
}
