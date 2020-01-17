package com.booking.business.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.CustomerManager;
import com.booking.commons.CustomerDTO;
import com.booking.commons.ReservationDTO;
import com.booking.persistence.dao.CustomerDao;
import com.booking.persistence.model.Customer;
import com.booking.persistence.model.Reservation;



public class CustomerManagerImpl implements CustomerManager {
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	CustomerDao customerDao= appContext.getBean(CustomerDao.class);
	
	 public CustomerDTO getCustomer(int id) {
		 CustomerDTO customerDTO = new CustomerDTO();
		 Customer customer=customerDao.getCustomerById(id);
		 customerDTO.setCustomerEmail(customer.getCustomerEmail());
		 customerDTO.setCustomerFirstName(customer.getCustomerFirstName());
		 customerDTO.setCustomerId(customer.getCustomerId());
		 customerDTO.setCustomerLastName(customer.getCustomerLastName());
		 customerDTO.setCustomerPhone(customer.getCustomerPhone());
		 customerDTO.setReservationDTOList(reservationDaoToDto(customer.getReservations()));
		 return customerDTO;
	 }
	 public Set<ReservationDTO> reservationDaoToDto(Set<Reservation> reservation) {
		 Set<ReservationDTO> rDTO =new HashSet<ReservationDTO>();
		 for(Reservation r:reservation) {
			 ReservationDTO res= new ReservationDTO();
			 res.setReservationId(r.getReservationId());
			 res.setReservationDateEnd(r.getReservationDateEnd());
			 res.setReservationDateStart(r.getReservationDateStart());
			 res.setReservationLocation(r.getReservationLocation());
			 res.setReservationPrice(r.getReservationPrice());
			 res.setReservationDescription(r.getReservationDescription());
			 rDTO.add(res);
		 }
		 return rDTO;
	 }
}
