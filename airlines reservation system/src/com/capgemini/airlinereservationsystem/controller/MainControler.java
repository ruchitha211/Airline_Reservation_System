package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

public class MainControler {
	
	public static void main(String[] args) {
		
       Scanner scanner = new Scanner(System.in);
		
		System.out.println("---------------------------WELCOME TO LIBRARY---------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Press 1 to Admin Page");
		System.out.println("Press 2 to User Page");
		System.out.println("------------------------------------------------------------------------");

		int i = scanner.nextInt();
		switch(i) {
		case 1:
			
		
		 AdminController con=new AdminController();
		 con.process();
		 break;
		
		case 2:
			UserContoller user=new UserContoller();
			user.getprocess();
			break;
			
	}
	

}
}
