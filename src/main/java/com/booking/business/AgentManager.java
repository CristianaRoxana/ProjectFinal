package com.booking.business;

import java.util.Set;

import com.booking.commons.AgentDTO;
import com.booking.commons.OfferDTO;
import com.booking.persistence.model.Offer;

public interface AgentManager {
	 public AgentDTO getAgent(int id);
	 public Set<OfferDTO> offerDaoToDto(Set<Offer> offers); 
	 
}
