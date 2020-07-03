package com.javafsfeb.airlinereservationwithjdbc.factory;

import com.javafsfeb.airlinereservationwithjdbc.dao.AdminDao;
import com.javafsfeb.airlinereservationwithjdbc.dao.AdminDaoImpl;
import com.javafsfeb.airlinereservationwithjdbc.dao.UserDao;
import com.javafsfeb.airlinereservationwithjdbc.dao.UserDaoImpl;
import com.javafsfeb.airlinereservationwithjdbc.services.AdminService;
import com.javafsfeb.airlinereservationwithjdbc.services.AdminServiceImpl;
import com.javafsfeb.airlinereservationwithjdbc.services.UserService;
import com.javafsfeb.airlinereservationwithjdbc.services.UserServiceImpl;

public class UserFactory {
	private UserFactory() {
		
	}

	public static UserDao getDaoImplInstance(){
		UserDao dao=new UserDaoImpl();
		return dao;
	}
	public static AdminDao getAdminImplInstance() {
		AdminDao admin=new AdminDaoImpl();
		return admin;
	}
	public static AdminService getAdminServiceInstance() {
		AdminService service=new AdminServiceImpl();
		return 	service;
	}
	public static UserService getUserServiceImplInstance() {
		UserService  userservice=new UserServiceImpl();
		return userservice;
	}
}
