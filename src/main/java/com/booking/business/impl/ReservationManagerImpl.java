package com.booking.business.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.ReservationManager;
import com.booking.commons.ReservationDTO;
import com.booking.persistence.dao.ReservationDao;
import com.booking.persistence.model.Reservation;

public class ReservationManagerImpl implements ReservationManager{
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	ReservationDao reservationDao= appContext.getBean(ReservationDao.class);
	 public ReservationDTO getReservation(int id) {
		 ReservationDTO reservationDTO= new ReservationDTO(); 
		 Reservation reservation=reservationDao.getReservationById(id);
		 reservationDTO.setReservationDateEnd(reservation.getReservationDateEnd());
		 reservationDTO.setReservationDateStart(reservation.getReservationDateStart());
		 reservationDTO.setReservationDescription(reservation.getReservationDescription());
		 reservationDTO.setReservationLocation(reservation.getReservationLocation());
		 reservationDTO.setReservationPrice(reservation.getReservationPrice());
		return reservationDTO;
	 }
}
