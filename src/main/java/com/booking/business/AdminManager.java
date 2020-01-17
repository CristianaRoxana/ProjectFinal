package com.booking.business;

import java.util.List;
import java.util.Set;

import com.booking.commons.AdminDTO;
import com.booking.commons.AgentDTO;
import com.booking.persistence.model.Agent;
import com.booking.persistence.model.Offer;

public interface AdminManager {
 public AdminDTO getAdmin(int id);
 public List<AdminDTO> getAdmins() ;
 public Set<AgentDTO> agentDaoToDto(Set<Agent> agents);
 //public Set<AgentDTO> agentDaoToDto(Set<Agent> agents,Set<Offer> offers);
}
