package com.javafsfeb.airlinereservationsystemwithspring.dao;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.javafsfeb.airlinereservationsystemwithspring.dto.BookReservationInfoBean;
import com.javafsfeb.airlinereservationsystemwithspring.dto.FlightDetailsInfoBean;
import com.javafsfeb.airlinereservationsystemwithspring.dto.RegistrationIfoBean;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	private EntityManagerFactory factory;
	private EntityManager manager = null;
	private EntityTransaction transaction = null;

	public boolean register(RegistrationIfoBean login) {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(login);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();

		}
	}

	public RegistrationIfoBean authentication(String email, String password) {
		try {

			manager = factory.createEntityManager();
			String jpql = "select r from RegistrationIfoBean r where r.email=:email and r.password=:password and r.role=admin ";
			TypedQuery<RegistrationIfoBean> query = manager.createQuery(jpql, RegistrationIfoBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			RegistrationIfoBean bean = query.getSingleResult();
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();

		}
	}

	public boolean addFlight(FlightDetailsInfoBean flight) {

		try (FileInputStream info = new FileInputStream("connectioninfo.properties");) {
			Properties pro = new Properties();
			pro.load(info);

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(flight);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();

		}
	}

	public boolean removeFlight(int flightcode) {

		try (FileInputStream info = new FileInputStream("connectioninfo.properties");) {
			Properties pro = new Properties();
			pro.load(info);

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			FlightDetailsInfoBean record = manager.find(FlightDetailsInfoBean.class, flightcode);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();

		}
	}

	public FlightDetailsInfoBean searchFlightBySource(String source) {
		try (FileInputStream info = new FileInputStream("connectioninfo.properties");) {
			Properties pro = new Properties();
			pro.load(info);

			manager = factory.createEntityManager();
			String jpql = "select f from FlightDetailsInfoBean f where f.source=:source";
			TypedQuery<FlightDetailsInfoBean> query = manager.createQuery(jpql, FlightDetailsInfoBean.class);
			query.setParameter("bookId", source);
			FlightDetailsInfoBean recordList = query.getSingleResult();
			return recordList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();

		}
	}

	public FlightDetailsInfoBean searchFlightByDestination(String destination) {

		try (FileInputStream info = new FileInputStream("connectioninfo.properties");) {
			Properties pro = new Properties();
			pro.load(info);

			manager = factory.createEntityManager();
			String jpql = "select f from FlightDetailsInfoBean f where f.destination=:destination";
			TypedQuery<FlightDetailsInfoBean> query = manager.createQuery(jpql, FlightDetailsInfoBean.class);
			query.setParameter("destination", destination);
			FlightDetailsInfoBean recordList = query.getSingleResult();
			return recordList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();

		}
	}

	public FlightDetailsInfoBean searchFlightBycode(String code) {
		try (FileInputStream info = new FileInputStream("connectioninfo.properties");) {
			Properties pro = new Properties();
			pro.load(info);

			manager = factory.createEntityManager();
			String jpql = "select f from FlightDetailsInfoBean f where f.code=:code";
			TypedQuery<FlightDetailsInfoBean> query = manager.createQuery(jpql, FlightDetailsInfoBean.class);
			query.setParameter("fcode", code);
			FlightDetailsInfoBean recordList = query.getSingleResult();
			return recordList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();

		}
	}

	public List<FlightDetailsInfoBean> getFlightDetails() {

		manager = factory.createEntityManager();
		String jpql = "select f from FlightDetailsInfoBean f";
		TypedQuery<FlightDetailsInfoBean> query = manager.createQuery(jpql, FlightDetailsInfoBean.class);
		List<FlightDetailsInfoBean> recordList = query.getResultList();
		manager.close();

		return recordList;
	}

	public List<BookReservationInfoBean> showReservations() {

		manager = factory.createEntityManager();
		String jpql = "select b from BookReservationInfoBean b";
		TypedQuery<BookReservationInfoBean> query = manager.createQuery(jpql, BookReservationInfoBean.class);
		List<BookReservationInfoBean> recordList = query.getResultList();
		manager.close();

		return recordList;
	}

}
