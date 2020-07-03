package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PassengerDetailsInfoBean  implements Serializable{
	
	private int passengerid;
	private String passportnumber;
	private String visano;
	private String source;
	private String destination;
	
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private int contactno;
	private int age;
	private String gender;

	
	public PassengerDetailsInfoBean(int passengerid, String passportnumber, String visano, String source, String destination, String firstname, String lastname, String email, String address, int contactno, int age, String gender) {
		this.passengerid=passengerid;
		this.passportnumber=passportnumber;
		this.visano=visano;
		this.source=source;
		this.destination=destination;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.address=address;
		this.contactno=contactno;
		this.age=age;
		this.gender=gender;
	}
	
	

	public PassengerDetailsInfoBean() {
		
	}



	@Override
	public String toString() {
		return "PassengerDetailsInfoBean [passengerid=" + passengerid + ", passportnumber=" + passportnumber
				+ ", visano=" + visano + ", source=" + source + ", destination=" + destination + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", address=" + address + ", contactno="
				+ contactno + ", age=" + age + ", gender=" + gender + "]";
	}

	public int getPassengerid() {
		return passengerid;
	}
	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}
	public String getPassportnumber() {
		return passportnumber;
	}
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	public String getVisano() {
		return visano;
	}
	public void setVisano(String visano) {
		this.visano = visano;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
