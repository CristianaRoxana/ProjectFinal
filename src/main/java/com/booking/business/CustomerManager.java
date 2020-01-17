package com.booking.business;

import java.util.Set;

import com.booking.commons.CustomerDTO;
import com.booking.commons.ReservationDTO;
import com.booking.persistence.model.Reservation;

public interface CustomerManager {
	public CustomerDTO getCustomer(int id);
	public Set<ReservationDTO> reservationDaoToDto(Set<Reservation> reservation);
}
