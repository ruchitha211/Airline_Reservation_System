package com.jfsfeb.airlinereservationsystem.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class UserLoginInfoBean {
	
	private int regId;
	private String userName;
	private String emailId;
	@ToString.Exclude
	private String password;
	private Long mobileNumber;
	
	


}

