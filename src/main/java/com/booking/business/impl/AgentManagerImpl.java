package com.booking.business.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.AgentManager;
import com.booking.commons.AgentDTO;
import com.booking.commons.OfferDTO;
import com.booking.persistence.dao.AgentDao;
import com.booking.persistence.model.Agent;
import com.booking.persistence.model.Offer;

public class AgentManagerImpl implements AgentManager {
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	AgentDao agentDao = appContext.getBean(AgentDao.class);

	public AgentDTO getAgent(int id) {
		AgentDTO agentDTO = new AgentDTO();
		Agent agent = agentDao.getAgentById(id);
		agentDTO.setAgentName(agent.getNameAgent());
		agentDTO.setIdAgent(agent.getIdAgent());
		agentDTO.setAgentDetails(agent.getDetailsAgent());
		agentDTO.setOffersDTOList(offerDaoToDto(agent.getOffers()));
		return agentDTO;
	}

	public Set<OfferDTO> offerDaoToDto(Set<Offer> offers) {
		Set<OfferDTO> oDTO = new HashSet<OfferDTO>();
		for (Offer o : offers) {
			OfferDTO offer = new OfferDTO();
			offer.setIdOffer(o.getIdOffer());
			offer.setOfferDetails(o.getOfferDetails());
			oDTO.add(offer);
		}
		return oDTO;
	}
}