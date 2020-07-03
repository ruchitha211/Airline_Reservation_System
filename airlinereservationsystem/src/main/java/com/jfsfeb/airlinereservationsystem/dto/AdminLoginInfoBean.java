package com.jfsfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
public class AdminLoginInfoBean implements Serializable {

	private int adminId;
	private String userName;
	private String emailId;
	@ToString.Exclude
	private String password;
	private Long mobileNumber;
	
	

}
