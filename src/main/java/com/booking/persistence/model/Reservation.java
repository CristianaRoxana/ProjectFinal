package com.booking.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.booking.commons.ReservationDTO;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationPrice=" + reservationPrice
				+ ", reservationDateStart=" + reservationDateStart + ", reservationDateEnd=" + reservationDateEnd
				+ ", reservationLocation=" + reservationLocation + ", reservationDescription=" + reservationDescription
				+ ", customer=" + customer + ", offer=" + offer + "]";
	}

	private int reservationId;
	//private int offerId;
	private int reservationPrice;
	private String reservationDateStart;
	private String reservationDateEnd;
	private String reservationLocation;
	private String reservationDescription;
	private Customer customer;
	private Offer offer;

	
	
	public Reservation() {
		super();
	}
	public Reservation(Offer offer, Customer customer, int reservationPrice,String reservationDateStart,String reservationDateEnd, String reservationLocation,String reservationDescription) {
		this.reservationPrice = reservationPrice;
		this.reservationDateStart = reservationDateStart;
		this.reservationDateEnd = reservationDateEnd;
		this.reservationLocation = reservationLocation;
		this.reservationDescription = reservationDescription;
		this.customer=customer;
		this.offer=offer;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ReservationID", unique = true, nullable = false)
	public int getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OfferId", nullable = false)
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	@Column(name = "ReservationPrice", nullable = false)
	public int getReservationPrice() {
		return reservationPrice;
	}

	public void setReservationPrice(int reservationPrice) {
		this.reservationPrice = reservationPrice;
	}
	@Column(name = "ReservationDateStart")
	public String getReservationDateStart() {
		return reservationDateStart;
	}

	public void setReservationDateStart(String reservationDateStart) {
		this.reservationDateStart = reservationDateStart;
	}
	@Column(name = "ReservationDateEnd")
	public String getReservationDateEnd() {
		return reservationDateEnd;
	}

	public void setReservationDateEnd(String reservationDateEnd) {
		this.reservationDateEnd = reservationDateEnd;
	}
	@Column(name = "ReservationLocation")
	public String getReservationLocation() {
		return reservationLocation;
	}

	public void setReservationLocation(String reservationLocation) {
		this.reservationLocation = reservationLocation;
	}
	@Column(name = "ReservationDescription")
	public String getReservationDescription() {
		return reservationDescription;
	}

	public void setReservationDescription(String reservationDescription) {
		this.reservationDescription = reservationDescription;
	}
	

	
}
