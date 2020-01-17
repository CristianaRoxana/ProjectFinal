package com.booking.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.CustomerManager;
import com.booking.commons.CustomerDTO;
import com.booking.persistence.model.Customer;

/*
@Path("/customer")
public class CustomerWS {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CustomerManager cManager = context.getBean(CustomerManager.class);
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  CustomerDTO unCustomer(){
		return  cManager.getCustomer(2);
	}
}*/
