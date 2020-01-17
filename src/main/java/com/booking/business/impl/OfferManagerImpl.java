package com.booking.business.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.OfferManager;
import com.booking.commons.OfferDTO;
import com.booking.commons.ReservationDTO;
import com.booking.persistence.dao.OfferDao;
import com.booking.persistence.model.Offer;
import com.booking.persistence.model.Reservation;

public class OfferManagerImpl implements OfferManager {
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	OfferDao offerDao = appContext.getBean(OfferDao.class);

	public OfferDTO getOffer(int id) {
		OfferDTO offerDTO = new OfferDTO();
		Offer offer = offerDao.getOfferById(id);
		offerDTO.setIdOffer(offer.getIdOffer());
		offerDTO.setOfferDetails(offer.getOfferDetails());
		offerDTO.setReservationsDTOList(resDaoToDto(offer.getReservations()));
		return offerDTO;
	}
	 public Set<ReservationDTO> resDaoToDto(Set<Reservation> reservation) {
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
