package com.booking.persistence.dao;

import java.util.List;

import com.booking.persistence.model.Offer;

//import com.booking.persistence.model.Customer;



public interface OfferDao {
	public void addOffer(Offer offer);
	public void updateOffer(Offer offer);
	public List<Offer> listOffers();
	public Offer getOfferById(int offer);
	public void removeOffer(int offerID);
}
