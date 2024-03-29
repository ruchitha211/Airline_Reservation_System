package com.jfsfeb.airlinereservationsystem.factory;

import com.jfsfeb.airlinereservationsystem.dao.AdminDao;
import com.jfsfeb.airlinereservationsystem.dao.AdminDaoImpl;
import com.jfsfeb.airlinereservationsystem.dao.UserDao;
import com.jfsfeb.airlinereservationsystem.dao.UserDaoImpl;
import com.jfsfeb.airlinereservationsystem.services.AdminService;
import com.jfsfeb.airlinereservationsystem.services.AdminServiceImpl;
import com.jfsfeb.airlinereservationsystem.services.UserService;
import com.jfsfeb.airlinereservationsystem.services.UserServiceImpl;

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
