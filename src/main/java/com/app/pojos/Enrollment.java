package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enrollmentId;
    
	@Enumerated(EnumType.STRING)
	private TrainerRole module;
	
	@Enumerated(EnumType.STRING)
	private MemberShip memberShip;
	
	private double price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfEnrollment;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endOfEnrollment;
	
	private boolean paymentStatus;
	
	@OneToOne
	@JoinColumn(name="custId")
	private Customer customer;
 
	@OneToOne
	@JoinColumn(name="trainerId")
	private Trainer trainer;
	
	@OneToOne(mappedBy = "enrollment",orphanRemoval = true)
	@JsonIgnoreProperties("enrollment")
	@Fetch(FetchMode.JOIN)
    private DietPlan dietPlan;	
	
	public Enrollment() {
	System.out.println("in ctor of " +getClass().getName());
	}

	

	public Enrollment(TrainerRole module, MemberShip memberShip, double price, LocalDate dateOfEnrollment,
			LocalDate endOfEnrollment, boolean paymentStatus) {
		super();
		this.module = module;
		this.memberShip = memberShip;
		this.price = price;
		this.dateOfEnrollment = dateOfEnrollment;
		this.endOfEnrollment = endOfEnrollment;
		this.paymentStatus = paymentStatus;
		}



	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}





	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}





	public LocalDate getEndOfEnrollment() {
		return endOfEnrollment;
	}





	public void setEndOfEnrollment(LocalDate endOfEnrollment) {
		this.endOfEnrollment = endOfEnrollment;
	}





	public TrainerRole getModule() {
		return module;
	}



	public void setModule(TrainerRole module) {
		this.module = module;
	}



	


	public Integer getEnrollmentId() {
		return enrollmentId;
	}



	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}



	public MemberShip getMemberShip() {
		return memberShip;
	}



	public void setMemberShip(MemberShip memberShip) {
		this.memberShip = memberShip;
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



	public DietPlan getDietPlan() {
		return dietPlan;
	}



	public void setDietPlan(DietPlan dietPlan) {
		this.dietPlan = dietPlan;
	}



	public boolean isPaymentStatus() {
		return paymentStatus;
	}


    public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", module=" + module + ", memberShip=" + memberShip
				+ ", dateOfEnrollment=" + dateOfEnrollment + ", endOfEnrollment=" + endOfEnrollment + ", paymentStatus="
				+ paymentStatus +", price=" + price +"]";
	}



	public void addDietPlan(DietPlan d)
	{
		dietPlan=d;
		d.setEnrollment(this);
	}
	
	public void removeDietPlan(DietPlan d)
	{
		dietPlan=null;
		d.setEnrollment(null);
	}
}
