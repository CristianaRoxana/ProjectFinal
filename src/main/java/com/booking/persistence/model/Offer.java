package com.booking.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idOffer;
	private String offerDetails;
	private Agent agent;
	private Set<Reservation> reservations1 = new HashSet<Reservation>(0);
	
	public Offer() {
		super();
	}
	public Offer(String offerDetails, int idOffer, int idAgent, Agent agent) {
		super();
		this.offerDetails=offerDetails;
		this.idOffer = idOffer;
		this.agent = agent;
	}
	@Id
	@Column(name = "OfferId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}
	
	@Column(name = "OfferDetails")
	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}
	public String getOfferDetails() {
		return offerDetails;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AgentId", nullable = false)
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@OneToMany(fetch=FetchType.LAZY, mappedBy="offer")
	public Set<Reservation> getReservations() {
			return this.reservations1;
		}

	public void setReservations(Set<Reservation> reservations) {
			this.reservations1 = reservations;
		}
		@Override
		public String toString() {
			return "Offer [idOffer=" + idOffer + ", offerDetails=" + offerDetails + ", agent=" + agent
					+ "]";
		}	
}
