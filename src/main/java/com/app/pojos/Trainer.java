package com.app.pojos;

import java.util.Arrays;

import java.util.List;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="trainer_profile")
public class Trainer {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainerId;
	@Column(length = 30)
	private String trainerName;
	@Email
	@Column(nullable = false,unique = true)
	private String trainerEmail;
	@Column(nullable = false,unique = true)
	@Length(min = 10,max = 10)
	private String trainerPhoneNumber;
	@Column(nullable = false)
	private String trainerPass; 
	
	@Enumerated(EnumType.STRING)
	private TrainerRole trainerRole;
	
	@Lob
	private String photo;
	@Lob
	private String certificate;
	 
	private double priceForSixMonth;
	
	private double priceForThreeMonth;
	 
	@Lob
	private String description;
	private double rating;
	@Enumerated(EnumType.STRING)
	private ApprovalStatus status;
   
	 @OneToMany(mappedBy = "trainer",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
     @JsonIgnoreProperties("trainer")
     @Basic(optional = true)
     @Fetch(FetchMode.JOIN)
     private List<Enrollment> enrollments;
	
	
	  @OneToOne(mappedBy = "trainer",cascade = CascadeType.ALL,orphanRemoval =true)
	  @JsonIgnoreProperties("trainer")
	  @Basic(optional = true)
	  @Fetch(FetchMode.JOIN)
	  private TrainerSchedule trainerSchedule;
	 
	  @OneToOne(mappedBy = "trainer",cascade = CascadeType.ALL, orphanRemoval =true)
	  @JsonIgnoreProperties("trainer")
	  @Basic(optional = true)
	  private Address address; 
	  
	  
public Trainer() {
	System.out.println("in ctor of " +getClass().getName());
	}


public Trainer(String trainerName, @Email String trainerEmail, @Length(min = 10, max = 10) String trainerPhoneNumber,
		String trainerPass, TrainerRole trainerRole, String photo, double priceForSixMonth, double priceForThreeMonth,
		String certificate, String description, double rating, ApprovalStatus status, List<Enrollment> enrollments,
		TrainerSchedule trainerSchedule, Address address) {
	super();
	this.trainerName = trainerName;
	this.trainerEmail = trainerEmail;
	this.trainerPhoneNumber = trainerPhoneNumber;
	this.trainerPass = trainerPass;
	this.trainerRole = trainerRole;
	this.photo = photo;
	this.priceForSixMonth = priceForSixMonth;
	this.priceForThreeMonth = priceForThreeMonth;
	this.certificate = certificate;
	this.description = description;
	this.rating = rating;
	this.status = status;
	this.enrollments = enrollments;
	this.trainerSchedule = trainerSchedule;
	this.address = address;
}








public Integer getTrainerId() {
	return trainerId;
}

public void setTrainerId(Integer trainerId) {
	this.trainerId = trainerId;
}

public String getTrainerName() {
	return trainerName;
}

public void setTrainerName(String trainerName) {
	this.trainerName = trainerName;
}

public String getTrainerEmail() {
	return trainerEmail;
}

public void setTrainerEmail(String trainerEmail) {
	this.trainerEmail = trainerEmail;
}

public String getTrainerPhoneNumber() {
	return trainerPhoneNumber;
}

public void setTrainerPhoneNumber(String trainerPhoneNumber) {
	this.trainerPhoneNumber = trainerPhoneNumber;
}

public String getTrainerPass() {
	return trainerPass;
}

public void setTrainerPass(String trainerPass) {
	this.trainerPass = trainerPass;
}

public TrainerRole getTrainerRole() {
	return trainerRole;
}

public void setTrainerRole(TrainerRole trainerRole) {
	this.trainerRole = trainerRole;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}


  
public String getCertificate() {
	return certificate;
}

public void setCertificate(String certificate) {
	this.certificate = certificate;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public double getRating() {
	return rating;
}

public void setRating(double rating) {
	this.rating = rating;
}

public ApprovalStatus getStatus() {
	return status;
}

public void setStatus(ApprovalStatus status) {
	this.status = status;
}

public List<Enrollment> getEnrollments() {
	return enrollments;
}

public void setEnrollments(List<Enrollment> enrollments) {
	this.enrollments = enrollments;
}

public TrainerSchedule getTrainerSchedule() {
	return trainerSchedule;
}

public void setTrainerSchedule(TrainerSchedule trainerSchedule) {
	this.trainerSchedule = trainerSchedule;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}


public double getPriceForSixMonth() {
	return priceForSixMonth;
}


public void setPriceForSixMonth(double priceForSixMonth) {
	this.priceForSixMonth = priceForSixMonth;
}


public double getPriceForThreeMonth() {
	return priceForThreeMonth;
}


public void setPriceForThreeMonth(double priceForThreeMonth) {
	this.priceForThreeMonth = priceForThreeMonth;
}




@Override
public String toString() {
	return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerEmail=" + trainerEmail
			+ ", TrainerPhoneNumber=" + trainerPhoneNumber + ", trainerRole=" + trainerRole + ", photo=" + photo
			+ ", priceForSixMonth=" + priceForSixMonth + ", priceForThreeMonth=" + priceForThreeMonth + ", certificate="
			+ certificate + ", description=" + description + ", rating=" + rating + ", status=" + status
			+ ", enrollments=" + enrollments + ", trainerSchedule=" + trainerSchedule + ", address=" + address + "]";
}


public void addEnrollment(Enrollment e)
{
	enrollments.add(e);
	e.setTrainer(this);
}

public void removeEnrollment(Enrollment e)
{
	enrollments.remove(e);
	e.setTrainer(null);
}

public void addTrainerSchedule(TrainerSchedule schedule)
{
	trainerSchedule=schedule;
	schedule.setTrainer(this);
}

public void removeTrainerSchedule(TrainerSchedule schedule)
{
	trainerSchedule=null;
	schedule.setTrainer(null);
}
public void addAddress(Address a)
{
	address=a;
	a.setTrainer(this);
}

public void removeAddress(Address a)
{
	address=null;
	a.setTrainer(null);
}

}
