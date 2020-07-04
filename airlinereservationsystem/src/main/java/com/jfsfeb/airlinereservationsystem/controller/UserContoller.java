package com.jfsfeb.airlinereservationsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystem.dto.BookReservationInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.jfsfeb.airlinereservationsystem.dto.UserLoginInfoBean;
import com.jfsfeb.airlinereservationsystem.exception.AirlineException;
import com.jfsfeb.airlinereservationsystem.factory.UserFactory;
import com.jfsfeb.airlinereservationsystem.services.UserService;
import com.jfsfeb.airlinereservationsystem.services.UserServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
@SuppressWarnings("resource")
public class UserContoller {
	
	UserService user1 = UserFactory.getUserServiceImplInstance();
	Scanner scanner = new Scanner(System.in);
	
	boolean flag = false;
	int regid = 0;
	String emailId = null;
	String password = null;
	String userName = null;
	long mobileNumber = 0;
	

	int noOfSeats = 0;

	String visano = null;
	String source = null;
	String destination = null;

	String passportno = null;
	
	
	public void getprocess() {
	
		do {
			try {
				log.info("------------------------------------------------------------------------------");
				log.info("Press 1 to user Registration");
				log.info("Press 2 to Login if already registered");
				log.info("press 3 to see all flight details");
				log.info("Press 4 to Exit");
				log.info("------------------------------------------------------------------------------");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					do {
						do {
							UserLoginInfoBean bean = new UserLoginInfoBean();
							log.info("Enter Your Full Name :");
							userName = scanner.next();
							bean.setUserName(userName);
							flag = user1.register(bean);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							UserLoginInfoBean bean1 = new UserLoginInfoBean();
							log.info("Enter regId to register it should contain 5 digits :");
							regid = scanner.nextInt();
							bean1.setRegId(regid);
							flag = user1.register(bean1);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							UserLoginInfoBean bean2 = new UserLoginInfoBean();
							log.info("Enter mobile number :");
							mobileNumber = scanner.nextLong();
							bean2.setMobileNumber(mobileNumber);
							flag = user1.register(bean2);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							UserLoginInfoBean bean = new UserLoginInfoBean();
							log.info("Enter Email :");
							emailId = scanner.next();
							bean.setEmailId(emailId);
							flag = user1.register(bean);
							if (flag == false) {
								log.info("not correct");
							}
						} while (!flag);
						do {
							UserLoginInfoBean bean = new UserLoginInfoBean();
							log.info("Enter Password :");
							password = scanner.next();
							bean.setPassword(password);
							flag = user1.register(bean);
							if (flag == false) {
								log.info("not correct");
							} else {
								log.info("Registered");
								subprocess();
							}

						} while (!flag);
					} while (flag == false);
					break;
				case 2:
					UserLoginInfoBean bean1 = new UserLoginInfoBean();
					do {
					log.info("Enter email :");
					String username1 = scanner.next();
					bean1.setEmailId(emailId);
					log.info("Enter Password :");
					String password1 = scanner.next();
					bean1.setPassword(password1);
					try {
						user1.authentication(username1, password1);
						log.info("Logged in");
						subprocess();// method calling
					} catch (Exception e) {
						log.info(" Invalid Credentials");
					}
					}while(!flag);
					break;
				case 3:
					flightdetails();
					break;

				case 4:
					SubController.mainprocess();
					break;

				default:
					log.info("Invalid Choice");
					break;
				}
			} catch (Exception ex) {
				log.info("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}
		} while (true);

	}// End of method

	public void subprocess() {

		

		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info("----------------------------------------------------------");
				log.info("Press 1 to Get  all the Flight Details");

				log.info("Press 2 to Search the flight by source");
				log.info("Press 3 to Search the flight by destination");
				log.info("Press 4 to Book a flight");
				log.info("press 5 for cancellation");

				log.info("Press 6 to main");
				log.info("---------------------------------------------------------");
				int choice2 = scanner.nextInt();
				switch (choice2) {
				case 1:
					List<FlightDetailsInfoBean> info = user1.getFlightDetails();
					for (FlightDetailsInfoBean fliBean : info) {

						if (fliBean != null) {
							log.info("-----------------------------------");
							log.info(fliBean.toString());
							// log.info("Flight code is-->" + fliBean.getFlightcode());
							// log.info("Flight Name is-->" + fliBean.getFlightname());
							// log.info("Source is-->" + fliBean.getSource());
							// log.info("Destination is-->" + fliBean.getDestination());
							// log.info("ArrivalTime is--->" + fliBean.getArrival_time());

						} else {
							log.info("flight info is not present");
						}
					}
					break;

				case 2:
					log.info("Search the flight by sourse");
					String source1 = scanner.next();
					FlightDetailsInfoBean bean3 = user1.searchFlightBySource(source1);
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
					String dest = scanner.next();

					FlightDetailsInfoBean bean4 = user1.searchFlightByDestination(dest);
					if (bean4 != null) {
						log.info("-----------------------------------");
						log.info(bean4.toString());
						// log.info("Flight code is-->" + bean4.getFlightcode());
						// log.info("Flight_Name is-->" + bean4.getFlightname());
						// log.info("Source is-->" + bean4.getSource());
						// log.info("Destination is-->" + bean4.getDestination());

					} else {
						log.info("No flights are available with this destination");
					}

					break;
				case 4:

					do {
						try {
							log.info("Enter source  :");
							source = scanner.next();

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
							log.info("Enter destination  :");
							destination = scanner.next();

							flag = true;
						} catch (InputMismatchException e) {
							flag = false;

						} catch (AirlineException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					FlightDetailsInfoBean bean10 = user1.booking(source, destination);
					//
					if (bean10 != null) {
						log.info(bean10.toString());
						// log.info(bean10.getFlightcode());
						// log.info(bean10.getFlightname());
						// log.info(bean10.getSource());
						// log.info(bean10.getDestination());
						// log.info(bean10.getArrival_time());
						log.info("------------------------------------------");
						log.info("press 1 to proceed booking");
						log.info("press 2 to cancel");
						log.info("-------------------------------------------");
						int choice3 = scanner.nextInt();
						switch (choice3) {
						case 1:
//							do {
//								try {
//									log.info("Enter passport number :");
//									passportno = scanner.next();
//
//									flag = true;
//								} catch (InputMismatchException e) {
//									flag = false;
//
//								} catch (AirlineException e) {
//									flag = false;
//									System.err.println(e.getMessage());
//								}
//							} while (!flag);
							do {
								try {
									log.info("Enter NO OF SEATS  :");
									noOfSeats = scanner.nextInt();

									flag = true;
								} catch (InputMismatchException e) {
									flag = false;

								} catch (AirlineException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
//							do {
//								try {
//									log.info("Enter visa number :");
//									visano = scanner.next();
//
//									flag = true;
//								} catch (InputMismatchException e) {
//									flag = false;
//
//								} catch (AirlineException e) {
//									flag = false;
//									System.err.println(e.getMessage());
//								}
//							} while (!flag);

							log.info("Enter Regid");
							int regid1 = scanner.nextInt();
							UserLoginInfoBean user = new UserLoginInfoBean();
							user.setRegId(regid1);
							log.info("Enter Flight code");
							String flightcode3 = scanner.next();
							FlightDetailsInfoBean flight = new FlightDetailsInfoBean();
							flight.setFlightcode(flightcode3);
							try {
								BookReservationInfoBean booked = new BookReservationInfoBean();
								booked.setPassportno(passportno);
								booked.setVisano(visano);
								booked.setNoofseats(noOfSeats);
								BookReservationInfoBean req = user1.ticket(user, flight);
								log.info("Booking Done succesfully");
								// log.info(req.toString());
								log.info("Reg id============"+req.getUser().getRegId());
								log.info("User Name=========="+req.getUser().getUserName());
								log.info("Flight Code+======="+req.getFbean().getFlightcode());
								log.info("Flight Name========="+req.getFbean().getFlightname());
								log.info("Source========="+req.getFbean().getSource());
								log.info("Destination====="+req.getFbean().getDestination());
								log.info("Arrivali time======="+req.getFbean().getArrival_time());
								log.info("Departure Time======="+req.getFbean().getDeparture_time());
								// log.info(req.getPassportno());
								// log.info(req.getVisano());

							} catch (AirlineException e) {

								log.info("Flight Booking unseccessful please try again!");
							}
							break;
						case 2:

							getprocess();

						}
					}

					////
					//// else {
					//// log.info("Sorry! No Flights are available for your source and
					//// destination");
					//// }
					//
					break;

				case 5:
					log.info(" Enter the regestration id to be removed");
					int pid = scanner.nextInt();
					try {
						boolean isRemoved = user1.cancellation(pid);
						if (isRemoved) {
							log.info("Ticket cancelled successfully");
						}
					} catch (AirlineException e) {
						log.info(e.getMessage());

					}

					break;

				case 6:
					getprocess();
					break;
				default:

					log.info("Incorrect entry. Please input only a positive integer.");
					break;
				}
			} catch (Exception ex) {
				log.info("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}
		} while (true);

	}// end of subprocess()

	public void flightdetails() {
		UserService user1 = new UserServiceImpl();

		List<FlightDetailsInfoBean> info = user1.getFlightDetails();
		for (FlightDetailsInfoBean fliBean : info) {

			if (fliBean != null) {
				log.info("-----------------------------------");
				log.info(fliBean.toString());
				// log.info("Flight code is-->" + fliBean.getFlightcode());
				// log.info("Flight Name is-->" + fliBean.getFlightname());
				// log.info("Source is-->" + fliBean.getSource());
				// log.info("Destination is-->" + fliBean.getDestination());
				// log.info("ArrivalTime is--->" + fliBean.getArrival_time());

			} else {
				log.info("flight info is not present");
			}
		}

	}
	public void getdetails() {
		do {
			try {
				log.info("Enter source  :");
				source = scanner.next();

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
				log.info("Enter destination  :");
				destination = scanner.next();

				flag = true;
			} catch (InputMismatchException e) {
				flag = false;

			} catch (AirlineException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		FlightDetailsInfoBean bean10 = user1.booking(source, destination);
		//
		if (bean10 != null) {
			log.info(bean10.toString());
			log.info("-----------------------------------------------------------------------------------------------------------");
			log.info("*****Before process for Booking you need to Login first , new user Register********");
			log.info("-----------------------------------------------------------------------------------------------------------");
	}
	}

} // End of class




//
//do {
//	UserLoginInfoBean bean = new UserLoginInfoBean();
//
//	do {
//		try {
//			log.info("Enter regId to register it should contain 5 digits :");
//			regid = scanner.nextInt();
//		//	validations.validatedId(regid);
//			bean.setRegId(regid);
//			flag = user1.register(bean);
//		System.out.println("Back to controller");	
//		} catch (InputMismatchException e) {
//			flag = false;
//			System.err.println("Id should contains only digits");
//			scanner.nextInt();
//		} catch (AirlineException e) {
//			flag = false;
//			System.err.println(e.getMessage());
//		}
//	} while (!flag);
//	do {
//		try {
//			log.info("Enter Your Full Name :");
//			userName = scanner.next();
//			// validation.validatedEmail(username1);
//			flag = user1.register(bean);
//		} catch (InputMismatchException e) {
//			flag = false;
//			System.err.println("name should be proper ");
//		} catch (AirlineException e) {
//			flag = false;
//			System.err.println(e.getMessage());
//		}
//	} while (!flag);
//
//	do {
//		try {
//			log.info("Enter mobile number :");
//			mobileNumber = scanner.nextLong();
//			// validation.validatedEmail(username1);
//			flag = true;
//		} catch (InputMismatchException e) {
//			flag = false;
//			System.err.println("mobile number should contain 10 digits ");
//		} catch (AirlineException e) {
//			flag = false;
//			System.err.println(e.getMessage());
//		}
//	} while (!flag);
//
//	do {
//		try {
//			log.info("Enter Email :");
//			emailId = scanner.next();
//			// validations.validatedEmail(username);
//			flag = true;
//		} catch (InputMismatchException e) {
//			flag = false;
//			System.err.println("Email should be proper ");
//		} catch (AirlineException e) {
//			flag = false;
//			System.err.println(e.getMessage());
//		}
//	} while (!flag);
//
//	do {
//		try {
//			log.info("Enter Password :");
//			password = scanner.next();
//			// validations.validatedPassword(password);
//			flag = true;
//		} catch (InputMismatchException e) {
//			flag = false;
//			System.err.println("Enter correct Password ");
//		} catch (AirlineException e) {
//			flag = false;
//			System.err.println(e.getMessage());
//		}
//	} while (!flag);
////			UserLoginInfoBean bean = new UserLoginInfoBean();
////	bean.setRegId(regid);
////	bean.setUserName(userName);
////	bean.setMobileNumber(mobileNumber);
////	bean.setEmailId(emailId);
////	bean.setPassword(password);
//
//	boolean check = user1.register(bean);
//	if (check) {
//		log.info("Registered");
//	} else {
//		log.info("Email already exist");
//	}
//	subprocess();
//	}while(flag);
//	break;
//
