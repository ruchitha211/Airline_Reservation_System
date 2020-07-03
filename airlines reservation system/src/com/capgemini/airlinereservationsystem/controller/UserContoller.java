package com.capgemini.airlinereservationsystem.controller;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.PassengerDetailsInfoBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginInfoBean;
import com.capgemini.airlinereservationsystem.exception.AirlineException;
import com.capgemini.airlinereservationsystem.services.UserService;
import com.capgemini.airlinereservationsystem.services.UserServiceImpl;
import com.capgemini.airlinereservationsystem.util.Validations;
@SuppressWarnings("resource")
public class UserContoller {
	public void getprocess() {
		boolean flag = false;
		int regid=0;
		String username2=null;
		String password2=null;
		
		int passengerid=0;
		String passportnumber=null;
		String visano=null;
		String firstname=null;
		String lastname=null;
		String email=null;
		String address=null;
		int contactno=0;
		int age=0;
		String gender=null;
	
		
		Validations validations=new Validations();
		UserService user1=new UserServiceImpl();

		Scanner scanner = new Scanner(System.in);
		do{
			try {
				System.out.println("-----------------------------------");
				System.out.println("Press 1 to user Registration");
				System.out.println("Press 2 to user Login");
				System.out.println("Press 3 to Exit");
				System.out.println("-----------------------------------");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					
					do {
						try {
							System.out.println("Enter ID :");
							regid = scanner.nextInt();
							validations.validatedId(regid);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Id should contains only digits");
						} catch (AirlineException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							System.out.println("Enter Email :");
							username2 = scanner.next();
							validations.validatedEmail(username2);
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
							password2 = scanner.next();
							validations.validatedPassword(password2);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Enter correct Password ");
						} catch (AirlineException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					UserLoginInfoBean bean=new UserLoginInfoBean();
					bean.setRegid(regid);
					bean.setUsername(username2);
					bean.setPassword(password2);

					boolean check = user1.register(bean);
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
						user1.authen(username, password);
						System.out.println("Logged in");
						do {
							try {
								System.out.println("--------------------------------------------");
								System.out.println("Press 1 to Search the flight by source");
								System.out.println("Press 2 to Search the flight by destination");
								System.out.println("Press 3 to Search the flight by fcode");
								System.out.println("Press 4 to Get  all the Flightdetails");
								System.out.println("press 5 for booking");
							
								
								System.out.println("Press 6 to main");
								System.out.println("--------------------------------------------");
								int choice2 = scanner.nextInt();
								switch (choice2) {
								case 1:
									System.out.println("Search the flight by sourse");
									String sour = scanner.next();
									FlightDetailsInfoBean bean3=user1.searchFlightBySource(sour);
									if(bean3!=null) {
					//					System.out.println(bean3.toString());
										System.out.println("-----------------------------------");
										System.out.println("Flight code is-->"+bean3.getFlightcode());
									System.out.println("Flight_Name is-->"+bean3.getFlightname());
									System.out.println("Source is-->"+bean3.getSource());
									System.out.println("Destination is-->"+bean3.getDestination());
			
									}else {
										System.out.println("No flights are available");
									}
								

									
							
									
									break;
								case 2:
									System.out.println("  Search the flight by the destination :");
									String dest = scanner.next();

									FlightDetailsInfoBean bean4 = user1.searchFlightByDestination(dest);
								    if(bean4!=null) {
											System.out.println("-----------------------------------");
											System.out.println("Flight code is-->"+bean4.getFlightcode());
											System.out.println("Flight_Name is-->"+bean4.getFlightname());
											System.out.println("Source is-->"+bean4.getSource());
											System.out.println("Destination is-->"+bean4.getDestination());
											
										} else {
											System.out.println("No flights are available with this destination");
										}
									
									break;
								case 3:
									System.out.println("Search the flight by the code:");
									String code = scanner.next();
									FlightDetailsInfoBean bean5 =user1.searchFlightBycode(code);
									if(bean5!=null)
									{	
										System.out.println("-----------------------------------");
											System.out.println("Flight code is-->"+bean5.getFlightcode());
											System.out.println("Flight name is-->"+bean5.getFlightname());
											System.out.println("source is-->"+bean5.getSource());
											System.out.println("destination is-->"+bean5.getDestination());
											
										} else {
											System.out.println("No flights are available with this code");
										}
									
									break;
								case 4:
									List<FlightDetailsInfoBean> info = user1.getFlightDetails();
									for (FlightDetailsInfoBean fliBean : info) {

										if (fliBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Flight code is-->"+fliBean.getFlightcode());
											System.out.println("Flight Name is-->"+fliBean.getFlightname());
											System.out.println("Source is-->"+fliBean.getSource());
											System.out.println("Destination is-->"+fliBean.getDestination());
											System.out.println("ArrivalTime is--->"+fliBean.getArrival_time());
										
										} else {
											System.out.println("flight info is not present");
										}
									}
									break;
								case 5:
									do {
										try {
											System.out.println("Enter your passengerID :");
											passengerid = scanner.nextInt();
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Id should contains only digits");
										} catch (AirlineException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);
									do {
										try {
											System.out.println("Enter passport number :");
											passportnumber = scanner.next();
											
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
											System.out.println("Enter visa number :");
											visano = scanner.next();
											
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
											System.out.println("Enter firstname :");
											firstname = scanner.next();
											
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
											System.out.println("Enter last name :");
											lastname = scanner.next();
											
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
											System.out.println("Enter Email :");
											username2 = scanner.next();
											
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
											System.out.println("Enter address :");
											address = scanner.next();
										
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
											System.out.println("Enter contact no :");
											contactno = scanner.nextInt();
											
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
											System.out.println("Enter age :");
											age = scanner.nextInt();
											
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
											System.out.println("Enter gender :");
											gender = scanner.next();
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											
										} catch (AirlineException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);
									PassengerDetailsInfoBean bean6=new PassengerDetailsInfoBean();
									bean6.setPassengerid(passengerid);
									bean6.setPassportnumber(passportnumber);
									bean6.setVisano(visano);
									bean6.setFirstname(firstname);
									bean6.setLastname(lastname);
									bean6.setEmail(email);
									bean6.setAddress(address);
									bean6.setContactno(contactno);
									bean6.setAge(age);
									bean6.setGender(gender);

									boolean check1 = user1.Ticketbooking(bean6);
									if(check1) {
										System.out.println("Booking Done successfully");
									} else {
										System.out.println("Email already exist");
									}
								
									
								case 6:
									getprocess();
								default:
									break;
								}
							} catch (Exception ex) {
								System.out.println("Incorrect entry. Please input only a positive integer.");
								scanner.nextLine();
							}
						} while(true);
					} catch (Exception e) {
						System.out.println("Invalid Credentials");
					}
					break;

				case 3:
					getprocess();
				default:
					System.out.println("Invalid Choice");
					break;
				}
			} catch (Exception ex) {
				System.out.println("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}
		} while(true);
		
								
					
					
		
	}//End of method
} // End of class
