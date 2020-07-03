package com.javafsfeb.airlinereservationwithhibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafsfeb.airlinereservationwithhibernate.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationwithhibernate.dto.RegistrationIfoBean;
import com.javafsfeb.airlinereservationwithhibernate.exception.AirlineException;
import com.javafsfeb.airlinereservationwithhibernate.factory.UserFactory;
import com.javafsfeb.airlinereservationwithhibernate.services.AdminService;
import com.javafsfeb.airlinereservationwithhibernate.services.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubController {
	static int i = 0;
	String role = null;

	boolean flag = false;
	String emailId = null;
	String password = null;
	long mobileNumber = 0;
	int adminId = 0;
	String adminName = null;
	AdminService service = UserFactory.getAdminServiceInstance();
	UserService user1 = UserFactory.getUserServiceImplInstance();

	public void mainprocess() {

		do {
			try {

				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);

				log.info("----------------************WELCOME TO AIRLINE RESERVATION SYSTEM************--------------");
				log.info("-------------------------------------------------------------------------------------------");
				log.info("Press 1 to See All Flight Details");
				log.info("Press 2 to Login");
				log.info("press 3 to Register (new User )");
				log.info("-------------------------------------------------------------------------------------------");

				i = scanner.nextInt();
				switch (i) {
				case 1:
					List<FlightDetailsInfoBean> info = service.getFlightDetails();
					for (FlightDetailsInfoBean fliBean : info) {

						if (fliBean != null) {

							log.info(fliBean.toString());
							// log.info("-----------------------------------");
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
					
					do {
						log.info("Enter email :");
						String emailId = scanner.next();
						log.info("Enter Password :");
						String password1 = scanner.next();
						log.info("Enter role User or admin");
						String roles=scanner.next();
						
						try {
							RegistrationIfoBean check = service.authentication(emailId, password1);
							 if (roles.equalsIgnoreCase("admin")) {
									log.info("logged in suscessfully!!!!");
									AdminController admin1 = new AdminController();
									admin1.subadminprocess();
								
							} else if (roles.equalsIgnoreCase("user")) {
								
								
									log.info("logged in suscessfully!!!!");
									UserContoller user = new UserContoller();
									user.subprocess();
								
							} else {
								log.info("Enter proper Details");
							}
						} catch (AirlineException e) {
					     System.err.println(e.getMessage());
                         flag=false;
						}


					} while (flag==false);

					break;

				case 3:
					do {
						do {
							try {

								log.info("Enter Your Full Name :");
								adminName = scanner.next();

								flag = true;

							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should be proper ");
							} catch (AirlineException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);
						do {
							try {

								log.info("Enter regId to register it should contain 5 digits :");
								adminId = scanner.nextInt();
								flag = true;

							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (AirlineException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (flag == false);

						do {
							try {

								log.info("Enter mobile number :");
								mobileNumber = scanner.nextLong();

								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("mobile number should contain 10 digits ");
							} catch (AirlineException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {

								log.info("Enter Email :");
								emailId = scanner.next();

								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (AirlineException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {

								log.info("Enter Password :");
								password = scanner.next();

								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (AirlineException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);
						do {
							try {

								log.info("Enter Role :");
								role = scanner.next();

								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter role as admin or user ");
							} catch (AirlineException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);
						RegistrationIfoBean regbean = new RegistrationIfoBean();
						regbean.setRegid(adminId);
						regbean.setName(adminName);
						regbean.setMobilenumber(mobileNumber);
						regbean.setEmailId(emailId);
						regbean.setPassword(password);
						regbean.setRole(role);
						try {
							if (role.equalsIgnoreCase("admin")) {

								boolean check = service.register(regbean);
								if (check) {
									log.info("Registered suscessfully!!!!");
									AdminController admin1 = new AdminController();
									admin1.subadminprocess();
								}
							} else if (role.equalsIgnoreCase("user")) {
								boolean checkuser = service.register(regbean);
								if (checkuser) {
									log.info("Registered suscessfully!!!!");
									UserContoller user = new UserContoller();
									user.subprocess();
								}
							} else {
								log.info("Enter proper Details");
							}
						} catch (InputMismatchException e) {

						}

					} while (flag == false);
					break;

				default:
					log.info("Invalid Choice enter proper number");
					break;
				}
			} catch (InputMismatchException ex) {
				log.info("Please provide either 1,2 or 3");

			} catch (AirlineException ex) {
				System.err.println(ex.getMessage());

			}
		} while (true);

	}

}
