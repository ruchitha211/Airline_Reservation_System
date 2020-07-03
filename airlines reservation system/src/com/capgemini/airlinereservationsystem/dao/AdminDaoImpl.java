package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.airlinereservationsystem.dto.BookReservationInfoBean;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsInfoBean;
import com.capgemini.airlinereservationsystem.exception.AirlineException;
import com.capgemini.airlinereservationsystem.repository.AirlineDataBase;
import com.capgemini.airlinereservationsystem.services.AdminService;
import com.capgemini.airlinereservationsystem.services.AdminServiceImpl;
import com.capgemini.airlinereservationsystem.dto.AdminLoginInfoBean;

public class AdminDaoImpl implements AdminDao{


	public boolean register(AdminLoginInfoBean login) {
		
		for(AdminLoginInfoBean adminbean:AirlineDataBase.dataadmin()) {
			if(adminbean.getUsername().equals(login.getUsername())) {
		
		return false;
	}
	}
	
	AirlineDataBase.dataadmin().add(login);
	return true;
	}

	public AdminLoginInfoBean authen(String username, String password) {
		
		for(AdminLoginInfoBean bean:AirlineDataBase.dataadmin()) {
			if(bean.getUsername().equals(username)&&bean.getPassword().equals(password)) {
			
				return bean;
			}
			throw new AirlineException("invalid username and password");
		}
		
		return null;
	}

	
	public boolean addflight(FlightDetailsInfoBean flight) {
		
		for(FlightDetailsInfoBean beans:AirlineDataBase.dataBase()) {
			if(beans.getFlightcode()==flight.getFlightcode()) {
			return false;
		}
		}
		AirlineDataBase.dataBase().add(flight);
		return true;
	}

	public boolean removeflight(String fcode) {
		
		boolean status=false;
		for(int i=0;i<=AirlineDataBase.dataBase().size()-1;i++)
		{
			FlightDetailsInfoBean remove=AirlineDataBase.dataBase().get(i);
			String retrieve=remove.getFlightcode();
			if(fcode==retrieve)
			{
				status=true;
				AirlineDataBase.dataBase().remove(i);
				break;
			}
		}
		return status;
	}
	


	@Override
	public FlightDetailsInfoBean searchFlightBySource(String source) {
		
		AdminService bysourse=new AdminServiceImpl();
	  for(FlightDetailsInfoBean sour: AirlineDataBase.dataBase()) {
		  if(sour.getSource().equals(source)) {
			  return sour;
		  }
	  
		
	
	}
	return null;
}

	@Override
	public FlightDetailsInfoBean searchFlightByDestination(String destination) {
		
		AdminService bydest=new AdminServiceImpl();
		for(FlightDetailsInfoBean dest: AirlineDataBase.dataBase()) {
			if(dest.getDestination().equals(destination)) {
				return dest;
		}
		}
		
		return null;
	}

	@Override
	public FlightDetailsInfoBean searchFlightBycode(String code) {
		
		AdminService bycode=new AdminServiceImpl();
		for(FlightDetailsInfoBean code1:AirlineDataBase.dataBase()) {
			if(code1.getFlightcode().equals(code)) {
				return code1;
			}
		}
		
		return null;
	}
	
	public ArrayList<FlightDetailsInfoBean> getFlightDetails() {
		
		return AirlineDataBase.dataBase();
	}

	public List<BookReservationInfoBean> showReservations() {
		
		List<BookReservationInfoBean> info = new LinkedList<BookReservationInfoBean>();
		for (BookReservationInfoBean reservationInfo : AirlineDataBase.bookeddata()) {
			reservationInfo.getRegid();
			reservationInfo.getPassengerid();
			reservationInfo.getNoofseats();
			reservationInfo.getStatus();
			reservationInfo.getDestination();
			info.add(reservationInfo);
		}
		return info;
	}
}


//public ArrayList<FlightDetailsInfoBean> searchFlightBySource(String source) {
//
//ArrayList<FlightDetailsInfoBean> searchList=new ArrayList<FlightDetailsInfoBean>();
//for(int i=0;i<=AirlineDataBase.flightinfo.size()-1;i++)
//{
//	FlightDetailsInfoBean source1=AirlineDataBase.flightinfo.get(i);
//	String retrivebysource=source1.getSource();
//	if(source.equals(retrivebysource))
//	{
//		searchList.add(source1);	
//		
//	}
//}
//if(searchList.size()==0)
//{
//	throw new AirlineException("there are no flights");
//}
//else
//{
//	return searchList;
//}
//
//}



//public ArrayList<FlightDetailsInfoBean> searchFlightByDestination(String destination) {
//
//ArrayList<FlightDetailsInfoBean> searchList=new ArrayList<FlightDetailsInfoBean>();
//for(int i=0;i<=AirlineDataBase.flightinfo.size()-1;i++)
//{
//	FlightDetailsInfoBean source1=AirlineDataBase.flightinfo.get(i);
//	String retrievedbydestination=source1.getDestination();
//	if(destination.equals(retrievedbydestination))
//	{
//		searchList.add(source1);	
//		return searchList;
//	}
//}
//if(searchList.size()==0)
//{
//	throw new AirlineException("there is no flights");
//}
//else
//{
//	return searchList;
//}
//
//}
//
//
//
//public ArrayList<FlightDetailsInfoBean> searchFlightBycode(String code) {
//
//ArrayList<FlightDetailsInfoBean> searchList=new ArrayList<FlightDetailsInfoBean>();
//for(int i=0;i<=AirlineDataBase.flightinfo.size()-1;i++)
//{
//	FlightDetailsInfoBean source1=AirlineDataBase.flightinfo.get(i);
//	String retrievedBycode=source1.getFlightcode();
//	if(code.equals(retrievedBycode))
//	{
//		searchList.add(source1);	
//		return searchList;
//	}
//}
//if(searchList.size()==0)
//{
//	throw new AirlineException("there is no flights");
//}
//else
//{
//	return searchList;
//}
//
//}
//
//















