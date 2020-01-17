package com.booking.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.booking.commons.CustomerDTO;
import com.booking.commons.ReservationDTO;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerPhone=" + customerPhone + ", customerEmail=" + customerEmail + "]";
	}
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerPhone;
	private String customerEmail;
	private Set<Reservation> reservations = new HashSet<Reservation>(0);
	
	public Customer() {
		super();
	}

	public Customer(String customerFirstName, String customerLastName, String customerPhone, String customerEmail) {
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CustomerID", unique = true, nullable = false)
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "CustomerFirstName")
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	@Column(name = "CustomerLastName")
	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	@Column(name = "CustomerPhone")
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Column(name = "CustomerEmail")
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	 @OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	/*public CustomerDTO asDTO() {
		final Set<ReservationDTO> reservationDTOList = new HashSet<ReservationDTO>();
		for (final ReservationDTO reservation : reservationDTOList) {
			reservationDTOList.add(reservation.asDTO());
		}

		return new CustomerDTO(this.customerId,this.customerEmail,this.customerFirstName,this.customerLastName,this.customerPhone,reservationDTOList);
	}
	*/
}
