package com.booking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.impl.AdminManagerImpl;
import com.booking.business.impl.AgentManagerImpl;
import com.booking.business.impl.CustomerManagerImpl;
import com.booking.business.impl.OfferManagerImpl;
import com.booking.commons.AdminDTO;
import com.booking.persistence.dao.AdminDao;
import com.booking.persistence.dao.AgentDao;
import com.booking.persistence.dao.CustomerDao;
import com.booking.persistence.dao.OfferDao;
import com.booking.persistence.dao.ReservationDao;
import com.booking.persistence.daoimpl.AdminDaoImpl;
import com.booking.persistence.model.Admin;
import com.booking.persistence.model.Agent;
import com.booking.persistence.model.Customer;
import com.booking.persistence.model.Offer;
import com.booking.persistence.model.Reservation;
import com.booking.persistence.util.HibernateUtil;


public class AppMain {
	public static void main(String[] args) {

	/*	System.out.println("Hibernate one to many, many to many ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Agent agent = new Agent();
		agent.setNameAgent("agent");
		agent.setDetailsAgent("agentDetails");
		agent.setIdAdmin(1);
		session.save(agent);

		Admin admin = new Admin();
		admin.setEmailAdmin("admin@yahoo.com");
		admin.setPasswordAdmin("pass");
		agent.getAdmins().add(admin);
		session.save(admin);
		*/
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
	 	AdminDao admDao= context.getBean(AdminDao.class);
	
		AgentDao agDao= context.getBean(AgentDao.class);

		Admin admin = new Admin();
		Agent agent = new Agent();
		Agent agent1 = new Agent();
		/*admin.setEmailAdmin("admin3@yahoo.com");
		admin.setPasswordAdmin("pass");
		admDao.addAdmin(admin);
		
		/*Admin i=admDao.getAdminById(admin.getIdAdmin());
		System.out.println("by ID::::::"+i);*/
		
	/*	List<Admin> adminiList = admDao.listAdmins();
		for(Admin a : adminiList){
			System.out.println(" Admin  List:"+a);
		}
		//admDao.removeAdmin(10);
		//admDao.removeAdmin(11);
		//admDao.removeAdmin(12);
		//admDao.removeAdmin(3);
		agent.setNameAgent("agent");
		agent.setDetailsAgent("agentDetails");
		agent.setNameAgent("numeAgent");
		
		agDao.addAgent(agent);
		
	//-------------------------	agDao.updateAgent(agent);
		
		List<Agent> agentiList = agDao.listAgents();
		for(Agent a : agentiList){
			System.out.println(" Agent  List:"+a.toString());
		}
		
	//	agDao.removeAgent(10);
		//agDao.removeAgent(11);
		//agDao.updateA(1);
		/*context.close();
		*/
		//****************      ONE TO MANY      ***********************
	/*	admin.setEmailAdmin("admin@yahoo.com");
		admin.setPasswordAdmin("pass");
		admDao.addAdmin(admin);
		
		agent.setNameAgent("agent");
		agent.setDetailsAgent("agentDetails");
		agent.setNameAgent("numeAgent");
		
		agent1.setNameAgent("agent1");
		agent1.setDetailsAgent("agentDetails1");
		agent1.setNameAgent("numeAgent1");
		
		agent.setAdmin(admin);
		agent1.setAdmin(admin);
		agDao.addAgent(agent);
		agDao.addAgent(agent1);
		
		List<Admin> adminiList = admDao.listAdmins();
		for(Admin a : adminiList){
			System.out.println(" Admin  List:"+a);
		}

		List<Agent> agentiList = agDao.listAgents();
		for(Agent a : agentiList){
			System.out.println(" Agent  List:"+a);
		}
		
		//****************     1 TO MANY      ***********************
		CustomerDao cDao= context.getBean(CustomerDao.class);
		ReservationDao rDao= context.getBean(ReservationDao.class);
		OfferDao oDao= context.getBean(OfferDao.class);
		
		
		
		Customer customer = new Customer();
		Reservation reservation = new Reservation();
		Reservation reservation1 = new Reservation();
		Offer offer=new Offer();
		Offer offer1=new Offer();
		
	
		
		customer.setCustomerEmail("customeremail@yahoo.com");
		customer.setCustomerFirstName("customerFirstName");
		customer.setCustomerLastName("customerLastName");
		customer.setCustomerPhone("09281983");
		//customer.setCustomerId(2);
		cDao.addCustomer(customer);
		
		
		
		offer.setOfferDetails("detaliile despre oferta");
		offer.setAgent(agent1);
		

		offer1.setOfferDetails("detaliile despre oferta111111");
		offer1.setAgent(agent1);
		//oDao.addOffer(offer);
		oDao.addOffer(offer1);
		
/*		reservation.setReservationDateEnd("12/05/2020");
		reservation.setReservationDateStart("10/05/2020");
		reservation.setReservationDescription("o noua rezervare");
		reservation.setReservationLocation("Bucuresti");
		reservation.setReservationPrice(120);
		reservation.setCustomer(customer);
		reservation.setOffer(offer1);
		rDao.addReservation(reservation);
	
		reservation1.setReservationDateEnd("08/05/2020");
		reservation1.setReservationDateStart("10/05/2020");
		reservation1.setReservationDescription("altarezervare");
		reservation1.setReservationLocation("Bucuresti");
		reservation1.setReservationPrice(120);
		reservation1.setCustomer(customer);
		reservation1.setOffer(offer1);
		
		rDao.addReservation(reservation1);
		
		context.close();*/
		AdminManagerImpl aManager= new AdminManagerImpl();
		System.out.println(aManager.getAdmin(3).toString());
	
		AgentManagerImpl agentManager= new AgentManagerImpl();
		System.out.println(agentManager.getAgent(5).toString());
		
		CustomerManagerImpl customerManager= new CustomerManagerImpl();
		System.out.println(customerManager.getCustomer(1).toString());
		
		OfferManagerImpl offerManager= new OfferManagerImpl();
		System.out.println(offerManager.getOffer(5).toString());
		System.out.println("Done");
		
	}
}


