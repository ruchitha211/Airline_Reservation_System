package com.javafsfeb.airlinereservationsystemwithspring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="registration")
public class RegistrationIfoBean implements Serializable {
	@Id
	@Column(name="id")
	private int regid;
	@Column
	private String name;
	@Column
	private long mobilenumber;
	@Column
	private String emailId;
	@Column
	private String password;
	@Column
	private String role;
	
}