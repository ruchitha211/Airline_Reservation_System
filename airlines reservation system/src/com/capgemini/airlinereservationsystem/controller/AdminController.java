package com.capgemini.airlinereservationsystem.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;
import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.exception.AirlineException;
import com.capgemini.airlinereservationsystem.services.AdminService;
import com.capgemini.airlinereservationsystem.services.AdminServiceImpl;
import com.capgemini.airlinereservationsystem.util.Validations;

public class AdminController {

	public void process() {
		
		boolean flag = false;
		String username1=null;
		String password1=null;
		
		String flightcode=null;
		String flightname=null;
		String source =null;
		String destination=null;
		LocalDateTime arrival_time=null;
		
		
		Validations validation=new Validations();
		Scanner scanner = new Scanner(System.in);
		AdminService service=new AdminServiceImpl();
		do{
			try {
				System.out.println("-----------------------------------");
				System.out.println("Press 1 to Admin Registration");
				System.out.println("Press 2 to Admin Login");
				System.out.println("Press 3 to Exit");
				System.out.println("-----------------------------------");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					
					do {
						try {
							System.out.println("Enter Email :");
							username1 = scanner.next();
							validation.validatedEmail(username1);
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
							System.out.println("Enter Password :");
							password1 = scanner.next();
							validation.validatedPassword(password1);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Enter correct Password ");
						} catch (AirlineException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					AdminLoginInfoBean bean =new AdminLoginInfoBean();
					
					bean.setUsername(username1);
					bean.setPassword(password1);

					boolean check = service.register(bean);
					if(check) {
						System.out.println("Registered");
					} else {
						System.out.println("Email already exist");
					}	

					break;
					
				case 2:
					System.out.println("Enter email :");
					String username = scanner.next();
					System.out.println("Enter Password :");
					String password = scanner.next();
					try {
						AdminLoginInfoBean login = service.authen(username, password);
						System.out.println("Logged in");

						do {
							try {
								System.out.println("-----------------------------------");
								System.out.println("Press 1 to Add Flights");
								System.out.println("Press 2 to Search the flight by sorce");
								System.out.println("Press 3 to Search the flight by destination");
								System.out.println("Press 4 to Search the flight by fcode");
								
								System.out.println("Press 5 to Get All The flight Information ");
								System.out.println("Press 6 to Show Reservation details");
								System.out.println("Press 7 to Main");
								System.out.println("-----------------------------------");
								int choice1 = scanner.nextInt();
								switch (choice1) {
								
								case 1:

									do {
										try {
											System.out.println("Enter Flight code :");
											flightcode = scanner.next();
										
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
											System.out.println("Enter Flight Name :");
											flightname = scanner.next();
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("FlightName should contains only Alphabets");
										} catch (AirlineException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);



									do {
										try {
											System.out.println("Enter source");
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
											System.out.println("Enter destination");
											destination = scanner.next();
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											
										} catch (AirlineException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);

                               FlightDetailsInfoBean bean1=new FlightDetailsInfoBean();
									bean1.setFlightcode(flightcode);
									bean1.setFlightname(flightname);
									bean1.setSource(source);
									bean1.setDestination(destination);
									bean1.setArrival_time(arrival_time);
									
									boolean check2 = service.addflight(bean1);
									if(check2) {
										System.out.println("Flight Added");
									} else {
										System.out.println("Flight already exist");
									}
									break;
									
								case 2:          
									System.out.println("Search the flight by sourse");
									String source1 = scanner.next();
									FlightDetailsInfoBean bean3 = service.searchFlightBySource(source1);
									if(bean3!=null) {
								//		System.out.println(bean3.toString());
							         System.out.println("search operation successful");
										System.out.println("-----------------------------------");
								
										System.out.println("Flight code is-->"+bean3.getFlightcode());
										System.out.println("Flight_Name is-->"+bean3.getFlightname());
										System.out.println("Source is-->"+bean3.getSource());
										System.out.println("Destination is-->"+bean3.getDestination());
										System.out.println("Arrival Time is--->"+bean3.getArrival_time());
			
									}
									else {
										System.out.println("flight not found");
									}		
										
									break;
								case 3:
									
									System.out.println("  Search the flight by the destination :");
									String destination1 = scanner.next();
									FlightDetailsInfoBean bean4 =service.searchFlightByDestination(destination1);
									if(bean4!=null) {
								//		System.out.println(bean4.toString());
										 System.out.println("search operation successful");
											System.out.println("-----------------------------------");
											System.out.println("Flight code is-->"+bean4.getFlightcode());
											System.out.println("Flight_Name is-->"+bean4.getFlightname());
											System.out.println("Source is-->"+bean4.getSource());
											System.out.println("Destination is-->"+bean4.getDestination());
				
									}
									else {
										System.out.println("flight not found");
									}
	

									break;
								case 4:
									System.out.println("Search the flight by the code:");
									String flightcode1 = scanner.next();
									FlightDetailsInfoBean bean5 =service.searchFlightBycode(flightcode1);
									if(bean5!=null) {
										System.out.println(bean5.toString());
									//	 System.out.println("search operation successful");
											System.out.println("-----------------------------------");
											System.out.println("Flight code is-->"+bean5.getFlightcode());
											System.out.println("Flight name is-->"+bean5.getFlightname());
											System.out.println("source is-->"+bean5.getSource());
											System.out.println("destination is-->"+bean5.getDestination());
										
									}
									else {
										System.out.println("flight not found");
									}
									

									break;
							

								case 5:
									
									ArrayList<FlightDetailsInfoBean> info = service.getFlightDetails();
									for (FlightDetailsInfoBean fliBean : info) {

										if (fliBean != null) {
											
										//	System.out.println(fliBean.toString());
											System.out.println("-----------------------------------");
											System.out.println("Flight code is-->"+fliBean.getFlightcode());
											System.out.println("Flight Name is-->"+fliBean.getFlightname());
											System.out.println("Source is-->"+fliBean.getSource());
											System.out.println("Destination is-->"+fliBean.getDestination());
										
										} else {
											System.out.println("flight info is not present");
										}
									}
									break;
								
								
								case 6:
									try {
										System.out.println("Requests for Books are :");
										System.out.println("-------------------------------");
                                        List<BookReservationInfoBean> reservation=service.showReservations();
										for (BookReservationInfoBean info1 : reservation) {
											System.out.println("........................");
											System.out.println("Registration id ---------- " + info1.getRegid());
											System.out.println("Flight Name -------- " + info1.getFlightcode());
											System.out.println("Passengerid id----------- " + info1.getPassengerid());
											System.out.println("no of seats -------- " + info1.getNoofseats());
											System.out.println("Status ------" + info1.getStatus());
											System.out.println("Destination------" + info1.getDestination());
											System.out.println(".........................");

										}
									} catch (Exception e) {
										System.out.println("no reservations present");
									}
									break;
								
								case 7:
									process();
								default:
									System.out.println("Invalid Choice");
									break;
								}
							}catch (Exception ex) {
								System.out.println("Incorrect entry. Please input only a positive integer.");
								scanner.nextLine();
							}
						} while(true);
					} catch (Exception e) {
						System.out.println("Invalid Credentials");
					}

					break;
				case 3:
					process();
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
			} catch (Exception ex) {
				System.out.println("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}
		} while(true);
								
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
								
							
								
						
		
		
		
	} //End of method

							

}// End of class
