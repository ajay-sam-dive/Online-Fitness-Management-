package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;

@Entity
public class Address {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	@Column(length = 30)
	private String city;
	@Column(length = 30)
	private String state;
	@Column(length = 30)
	private String country;
	@Column(length=30)
	private String landMark;
	
	private int pinCode;	
	
	@OneToOne
	@JoinColumn(name = "custId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="TrainerId")
	private Trainer trainer;
	
	public Address() {
	System.out.println("in ctor of " +getClass().getName());
	}

	

	public Address(String city, String state, String country, String landMark, int pinCode,
			Customer customer, Trainer trainer) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.landMark = landMark;
		this.pinCode = pinCode;
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	public Trainer getTrainer() {
		return trainer;
	}



	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}



	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", landMark=" + landMark
				+ ", pinCode=" + pinCode + "]";
	}

	
	
	
	
}
