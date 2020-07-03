package com.javafsfeb.airlinereservationsystemwithspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JpaConfiguration {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactory(){
		LocalEntityManagerFactoryBean factoryBean=new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("TestPersistence");
		
		return factoryBean;
	}

}
