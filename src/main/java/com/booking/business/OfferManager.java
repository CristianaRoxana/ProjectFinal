package com.booking.business;

import java.util.Set;

import com.booking.commons.OfferDTO;
import com.booking.commons.ReservationDTO;
import com.booking.persistence.model.Reservation;


public interface OfferManager {
	 public OfferDTO getOffer(int id);
	 public Set<ReservationDTO> resDaoToDto(Set<Reservation> reservation);
}
