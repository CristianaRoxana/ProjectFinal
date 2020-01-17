package com.booking.business.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.booking.business.AdminManager;
import com.booking.commons.AdminDTO;
import com.booking.commons.AgentDTO;
import com.booking.commons.OfferDTO;
import com.booking.persistence.dao.AdminDao;
import com.booking.persistence.dao.OfferDao;
import com.booking.persistence.model.Admin;
import com.booking.persistence.model.Agent;
import com.booking.persistence.model.Offer;

public class AdminManagerImpl implements AdminManager {
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	AdminDao adminDao = appContext.getBean(AdminDao.class);

	public AdminDTO getAdmin(int id) {
		AdminDTO adminDTO = new AdminDTO();
		Admin admin = adminDao.getAdminById(id);
		adminDTO.setEmail(admin.getEmailAdmin());
		adminDTO.setId(admin.getIdAdmin());
		adminDTO.setPassword(admin.getPasswordAdmin());
		adminDTO.setAgentDTOList(agentDaoToDto(admin.getAgents()));
		return adminDTO;
	}

	public List<AdminDTO> getAdmins() {
		List<Admin> admins = adminDao.listAdmins();
		List<AdminDTO> adminsDTO = new ArrayList<AdminDTO>();
		for (Admin admin : admins) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setEmail(admin.getEmailAdmin());
			adminDTO.setId(admin.getIdAdmin());
			adminDTO.setPassword(admin.getPasswordAdmin());
			adminsDTO.add(adminDTO);
		}
		return adminsDTO;
	}

	public Set<AgentDTO> agentDaoToDto(Set<Agent> agents) {
		Set<AgentDTO> aDTO = new HashSet<AgentDTO>();
		Set<OfferDTO> oDTO = new HashSet<OfferDTO>();
		OfferDao offerDao = appContext.getBean(OfferDao.class);
		
		for (Agent a : agents) {
			AgentDTO agent = new AgentDTO();
			agent.setAgentDetails(a.getDetailsAgent());
			agent.setAgentName(a.getNameAgent());
			agent.setIdAgent(a.getIdAgent());
			agent.setOffersDTOList(oDTO);
			aDTO.add(agent);
		}
		return aDTO;
	}
}
