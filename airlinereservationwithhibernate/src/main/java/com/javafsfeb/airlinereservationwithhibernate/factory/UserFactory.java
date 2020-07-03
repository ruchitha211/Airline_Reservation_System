package com.javafsfeb.airlinereservationwithhibernate.factory;

import com.javafsfeb.airlinereservationwithhibernate.dao.AdminDao;
import com.javafsfeb.airlinereservationwithhibernate.dao.AdminDaoImpl;
import com.javafsfeb.airlinereservationwithhibernate.dao.UserDao;
import com.javafsfeb.airlinereservationwithhibernate.dao.UserDaoImpl;
import com.javafsfeb.airlinereservationwithhibernate.services.AdminService;
import com.javafsfeb.airlinereservationwithhibernate.services.AdminServiceImpl;
import com.javafsfeb.airlinereservationwithhibernate.services.UserService;
import com.javafsfeb.airlinereservationwithhibernate.services.UserServiceImpl;

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
