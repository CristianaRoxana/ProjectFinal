package com.booking.persistence.daoimpl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.booking.persistence.dao.OfferDao;
import com.booking.persistence.model.Offer;


public class OfferDaoImpl implements OfferDao{
	private static final Log logger = LogFactory.getLog(OfferDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	static Session sessionObj;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public void addOffer(Offer offer) {
		sessionObj =this.sessionFactory.openSession();
		sessionObj.beginTransaction();
		sessionObj.persist(offer);
		sessionObj.getTransaction().commit();
		logger.info("Offer saved successfully, Offer Details="+offer);
	}

	
	public void updateOffer(Offer offer) {
		//sessionObj =this.sessionFactory.openSession();
		sessionObj.update(offer);
		logger.info(" Offer updated successfully, Offer  Details="+offer);
	}

	@SuppressWarnings("unchecked")
	
	public  List<Offer> listOffers() {
		List<Offer>offerList=null;
		sessionObj=this.sessionFactory.openSession();
		sessionObj.beginTransaction();
		offerList=(List<Offer>)sessionObj.createCriteria(Offer.class).list();
		return offerList;

	}

	
	public Offer getOfferById(int offerID) {
		sessionObj =this.sessionFactory.openSession();		
		Offer offer = (Offer) sessionObj.load(Offer.class, new Integer(offerID));
		logger.info(" Offer  loaded successfully,Offer  details="+offer);
		return offer;
		
	}

	
	public void removeOffer(int offerID) {
		sessionObj =this.sessionFactory.getCurrentSession();
		 try {sessionObj.beginTransaction();
			Offer offer = (Offer) sessionObj.load(Offer.class, new Integer(offerID));
			
				sessionObj.delete(offer);
			
			sessionObj.getTransaction().commit();
			//logger.info("Admin deleted successfully, admin details="+admin);
		}
		
	    catch (HibernateException e) {
	        e.printStackTrace();
	        sessionObj.getTransaction().rollback();
	    }

}
	
}
