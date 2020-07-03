package com.jfsfeb.airlinereservationsystem.controller;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;

import com.jfsfeb.airlinereservationsystem.exception.AirlineException;
import com.jfsfeb.airlinereservationsystem.factory.UserFactory;
import com.jfsfeb.airlinereservationsystem.services.AdminService;
import com.jfsfeb.airlinereservationsystem.services.AdminServiceImpl;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminController {

	Scanner scanner = new Scanner(System.in);
	AdminService service = UserFactory.getAdminServiceInstance();

	boolean flag = false;
	String emailId = null;
	String password = null;
	long mobileNumber = 0;
	int adminId = 0;
	String adminName = null;

	public void process() {

		do {

			try {
				log.info("-----------------------------------------------------------------------");
				log.info("Press 1 to Admin Registration");
				log.info("Press 2 to Admin Login");
				log.info("Press 3 to Exit");
				log.info("-----------------------------------------------------------------------");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					do {
						do {
							AdminLoginInfoBean bean = new AdminLoginInfoBean();
							log.info("Enter Your Full Name :");
							adminName = scanner.next();
							bean.setUserName(adminName);
							flag = service.register(bean);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							AdminLoginInfoBean bean1 = new AdminLoginInfoBean();
							log.info("Enter regId to register it should contain 5 digits :");
							adminId = scanner.nextInt();
							bean1.setAdminId(adminId);
							flag = service.register(bean1);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							AdminLoginInfoBean bean2 = new AdminLoginInfoBean();
							log.info("Enter mobile number :");
							mobileNumber = scanner.nextLong();
							bean2.setMobileNumber(mobileNumber);
							flag = service.register(bean2);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							AdminLoginInfoBean bean = new AdminLoginInfoBean();
							log.info("Enter Email :");
							emailId = scanner.next();
							bean.setEmailId(emailId);
							flag = service.register(bean);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							AdminLoginInfoBean bean = new AdminLoginInfoBean();
							log.info("Enter Password :");
							password = scanner.next();
							bean.setPassword(password);
							flag = service.register(bean);
							if (flag == false) {
								log.info("not correct");
							} else {
								log.info("Registered");
								subadminprocess();
							}

						} while (!flag);
					} while (flag == false);
					break;
				case 2:
					AdminLoginInfoBean bean=new AdminLoginInfoBean();
					log.info("Enter email :");
					String username1 = scanner.next();
                    bean.setEmailId(username1);
					log.info("Enter Password :");
					String password1 = scanner.next();
					bean.setPassword(password1);
					try {
						service.authentication(username1, password1);
						log.info("Logged in successfully!!!!");
						subadminprocess();

					} catch (Exception e) {
						System.out.println("Invalid Credentials");
						process();
					}

					break;
				case 3:
					SubController.mainprocess();
					break;

				default:
					System.out.println("Incorrect entry. Please provide either 1 , 2 or 3");
					process();
					break;

				}
			} catch (InputMismatchException ex) {
				log.info("Please provide either 1 ,2 or 3");
				scanner.nextLine();

			} catch (AirlineException ex) {
				System.err.println(ex.getMessage());
				// scanner.nextLine();
			}
		} while (true);

	}

	public void subadminprocess() {

		boolean flag = false;

		String flightcode = null;
		String flightname = null;
		String source = null;
		String destination = null;
		LocalDateTime arrival_time = null;
		LocalDateTime departure_time = null;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		AdminService service = new AdminServiceImpl();
		do {
			try {
				log.info("-----------------------------------");
				log.info("Press 1 to Add Flights");
				log.info("Press 2 to Search the flight by sorce");
				log.info("Press 3 to Search the flight by destination");
				log.info("Press 4 to Search the flight by fcode");

				log.info("Press 5 to Get All The flight Information ");
				log.info("Press 6 to Show Reservation details");
				log.info("Press 7 to remove the flight");
				log.info("Press 8 to Main");
				log.info("-----------------------------------");
				int choice1 = scanner.nextInt();
				switch (choice1) {

				case 1:
				do {
					do {
						
						FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
						log.info("Enter Your Flight code:");
						flightcode = scanner.next();
						bean.setFlightcode(flightcode);;
						flag = service.addFlight(bean);
						if (flag == false) {
							log.info("flight code is not correct");
						}
					} while (!flag);

                   do {
						
						FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
						log.info("Enter Flight Name :");
						flightname = scanner.next();
						bean.setFlightname(flightname);;
						flag = service.addFlight(bean);
						if (flag == false) {
							log.info("flight name is not correct");
						}
					} while (!flag);
                   do {
						
						FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
						log.info("Enter Source :");
						source = scanner.next();
						bean.setSource(source);
						flag = service.addFlight(bean);
						if (flag == false) {
							log.info("Enter proper source name ");
						}
					} while (!flag);
                   do {
						
						FlightDetailsInfoBean bean = new FlightDetailsInfoBean();
						log.info("Enter Destination :");
						destination = scanner.next();
						bean.setDestination(destination);
						flag = service.addFlight(bean);
						if (flag == false) {
							log.info("Enter proper destination name ");
						}
					} while (!flag);

					do {
						try {
							log.info("Enter Arrival Time to set");
							arrival_time = LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
									scanner.nextInt(), scanner.nextInt());

							flag = true;
						} catch (InputMismatchException e) {
							flag = false;

						} catch (AirlineException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							log.info("Enter Departure Time to set");
							departure_time = LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
									scanner.nextInt(), scanner.nextInt());

							flag = true;
						} catch (InputMismatchException e) {
							flag = false;

						} catch (AirlineException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					FlightDetailsInfoBean bean1 = new FlightDetailsInfoBean();
					bean1.setArrival_time(arrival_time);
					bean1.setDeparture_time(departure_time);

					boolean check2 = service.addFlight(bean1);
					if (check2) {
						log.info("Flight Added successfully!!!!");
					} else {
						log.info("Flight already exist");
					}
				}while(flag==false);
					break;

				case 2:
					log.info("Search the flight by sourse");
					String source1 = scanner.next();
					FlightDetailsInfoBean bean3 = service.searchFlightBySource(source1);
					if (bean3 != null) {
						log.info(bean3.toString());
						log.info("search operation successful");
						// log.info("-----------------------------------");
						//
						// log.info("Flight code is-->" + bean3.getFlightcode());
						// log.info("Flight_Name is-->" + bean3.getFlightname());
						// log.info("Source is-->" + bean3.getSource());
						// log.info("Destination is-->" + bean3.getDestination());
						//
						// log.info("Arrival Time is--->" + bean3.getArrival_time());

					} else {
						log.info("flight not found");
					}

					break;
				case 3:

					log.info("  Search the flight by the destination :");
					String destination1 = scanner.next();
					FlightDetailsInfoBean bean4 = service.searchFlightByDestination(destination1);
					if (bean4 != null) {
						log.info(bean4.toString());
						log.info("search operation successful");
						// log.info("-----------------------------------");
						// log.info("Flight code is-->" + bean4.getFlightcode());
						// log.info("Flight_Name is-->" + bean4.getFlightname());
						// log.info("Source is-->" + bean4.getSource());
						// log.info("Destination is-->" + bean4.getDestination());
						// log.info("Arrival time is-->" + bean4.getArrival_time());
					} else {
						log.info("flight not found");
					}

					break;
				case 4:
					log.info("Search the flight by the code:");
					String flightcode1 = scanner.next();
					FlightDetailsInfoBean bean5 = service.searchFlightBycode(flightcode1);
					if (bean5 != null) {
						log.info(bean5.toString());
						log.info("search operation successful");
						// log.info("-----------------------------------");
						// log.info("Flight code is-->" + bean5.getFlightcode());
						// log.info("Flight name is-->" + bean5.getFlightname());
						// log.info("source is-->" + bean5.getSource());
						// log.info("destination is-->" + bean5.getDestination());
						// log.info("Arrival time is-->" + bean5.getArrival_time());

					} else {
						log.info("flight not found");
					}

					break;

				case 5:

					List<FlightDetailsInfoBean> info = service.getFlightDetails();
					for (FlightDetailsInfoBean fliBean : info) {

						if (fliBean != null) {

							log.info(fliBean.toString());
							// log.info("-----------------------------------");
							// log.info("Flight code is-->" + fliBean.getFlightcode());
							// log.info("Flight Name is-->" + fliBean.getFlightname());
							// log.info("Source is-->" + fliBean.getSource());
							// log.info("Destination is-->" + fliBean.getDestination());
							//
							// log.info("ArrivalTime is--->" + fliBean.getArrival_time());

						} else {
							log.info("flight info is not present");
						}
					}
					break;

				case 6:
					try {
						log.info("Flight Booking details:");
						log.info("-------------------------------");
						List<BookReservationInfoBean> reservation = service.showReservations();

						for (BookReservationInfoBean info1 : reservation) {
							log.info("------------------------------------------------------------");
							log.info(info1.toString());
							// log.info("Passengerid id----------- " + info1.getPassengerid());
							// log.info("no of seats -------- " + info1.getNoofseats());
							// log.info("Status ------" + info1.getStatus());
							// log.info("Destination------" + info1.getDestination());
							log.info("------------------------------------------------------------");

						}
					} catch (Exception e) {
						log.info("No reservations present");
					}
					break;
				case 7:
					log.info(" Enter the flight code to be removed");
					String flightcode3 = scanner.next();
					try {
						boolean isRemoved = service.removeFlight(flightcode3);
						if (isRemoved) {
							log.info("Removed successfully");
						}
					} catch (AirlineException e) {
						log.info(e.getMessage());

					}

					break;

				case 8:
					process();
					break;
				default:
					log.info("Invalid Choice");
					break;
				}

			} catch (Exception ex) {
				System.out.println("Incorrect entry. Please provide the proper number  whatever there in the list ");
				scanner.nextLine();
			}
		} while (true);
	}

}// End of class

// String emailId = null;
// String password = null;
// long mobileNumber = 0;
// int adminId = 0;
// String adminName = null;
//
// @SuppressWarnings("resource")
// Scanner scanner = new Scanner(System.in);
//
// AdminService service = new AdminServiceImpl();
// do {
// try {
// log.info("-----------------------------------------------------------------------");
// log.info("Press 1 to Admin Registration");
// log.info("Press 2 to Admin Login");
// log.info("Press 3 to Exit");
// log.info("-----------------------------------------------------------------------");
// int choice = scanner.nextInt();
//
// switch (choice) {
// case 1:
// do {
// do {
// try {
// AdminLoginInfoBean bean = new AdminLoginInfoBean();
// log.info("Enter Your Full Name :");
// adminName = scanner.next();
// // validation.validatedName(adminName);
// // flag = true;
// bean.setUserName(adminName);
// flag = service.register(bean);
//
//
// } catch (InputMismatchException e) {
// flag = false;
// System.err.println("Name should be proper ");
// } catch (AirlineException e) {
// flag = false;
// System.err.println(e.getMessage());
// }
// } while (!flag);
// do {
// try {
// AdminLoginInfoBean bean = new AdminLoginInfoBean();
// log.info("Enter regId to register it should contain 5 digits :");
// adminId = scanner.nextInt();
// flag = true;
// // validation.validatedId(adminId);
//
//// flag = service.register(bean);
//// bean.setAdminId(adminId);
//
// } catch (InputMismatchException e) {
// flag = false;
// System.err.println("Id should contains only digits");
// } catch (AirlineException e) {
// flag = false;
// System.err.println(e.getMessage());
// }
// } while (flag == false);
//
// do {
// try {
//
// log.info("Enter mobile number :");
// mobileNumber = scanner.nextLong();
// // validation.validatedMobile(mobileNumber);
// flag = true;
// } catch (InputMismatchException e) {
// flag = false;
// System.err.println("mobile number should contain 10 digits ");
// } catch (AirlineException e) {
// flag = false;
// System.err.println(e.getMessage());
// }
// } while (!flag);
//
// do {
// try {
//
// log.info("Enter Email :");
// emailId = scanner.next();
// // validation.validatedEmail(emailId);
// flag = true;
// } catch (InputMismatchException e) {
// flag = false;
// System.err.println("Email should be proper ");
// } catch (AirlineException e) {
// flag = false;
// System.err.println(e.getMessage());
// }
// } while (!flag);
//
// do {
// try {
//
// log.info("Enter Password :");
// password = scanner.next();
// // validation.validatedPassword(password);
// flag = true;
// } catch (InputMismatchException e) {
// flag = false;
// System.err.println("Enter correct Password ");
// } catch (AirlineException e) {
// flag = false;
// System.err.println(e.getMessage());
// }
// } while (!flag);
// AdminLoginInfoBean bean = new AdminLoginInfoBean();
// bean.setAdminId(adminId);
// bean.setUserName(adminName);
// bean.setMobileNumber(mobileNumber);
// bean.setEmailId(emailId);
// bean.setPassword(password);
//
// boolean check = service.register(bean);
// if (check) {
// log.info("Registered");
// subadminprocess();
// } else {
// log.info("Enter proper Details");
// }
//
// } while (flag == false);
// break;
//
// case 2:
// log.info("Enter email :");
// String username1 = scanner.next();
//
// log.info("Enter Password :");
// String password1 = scanner.next();
// try {
// service.authentication(username1, password1);
// log.info("Logged in");
// subadminprocess();
//
// } catch (Exception e) {
// System.out.println("Invalid Credentials");
// }
//
// break;
// case 3:
// // SubController.mainprocess();
// break;
// default:
//
// System.out.println("press 1 for exit");
//
// break;
// }
// } catch (Exception ex) {
// System.out.println("Incorrect entry. Please provide either 1 , 2 or 3");
// process();
// scanner.nextLine();
// }
// } while (true);

// } // End of method
