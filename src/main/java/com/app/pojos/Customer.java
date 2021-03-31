package com.app.pojos;

import java.time.LocalTime;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customers")
public class Customer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;
	
	@Column(length = 30,nullable = false)
	private String custName;
    
	@Length(min = 10,max = 10)
	@Column(unique = true)
	private String custPhoneNumber;
	
	@Email
	@Column(length = 30,unique = true)
	private String custEmail;
	
	@Column(length = 30)
	private String custPassword;
    
	 @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,optional = true)
	 @JsonIgnoreProperties("customer")
     @Basic(optional = true)
     @Fetch(FetchMode.JOIN)
	private Address address;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	private int age;
	
	@Column(length=6)
	private String gender;
	
	private double height;
	private double weight;
	
	private String interest;
	
	private double bodyFat;
	
	private String fitnessLevel;
	private String activityLeval;
	private String foodPreference;
	private String goals;
	
	
	

	
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime startTime;
	
    
	@DateTimeFormat(iso = ISO.TIME)
    private LocalTime endTime;
   
   @Transient
   private String startTimeT;
   
   @Transient
   private String endTimeT;
    
    
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    @Basic(optional = true)
    @Fetch(FetchMode.JOIN)
    private Enrollment enrollment;
	
    public Customer() {
	System.out.println("in constructor of " +getClass().getName());
	}



	public Customer(String custName, @Length(min = 10, max = 10) String custPhoneNumber, @Email String custEmail,
			String custPassword, Address address, Date birthDate, int age, String gender, double height, double weight,
			String interest, double bodyFat, String fitnessLevel, String activityLeval, String foodPreference,
			String goals, LocalTime startTime, LocalTime endTime, String startTimeT, String endTimeT,
			Enrollment enrollment) {
		super();
		this.custName = custName;
		this.custPhoneNumber = custPhoneNumber;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.address = address;
		this.birthDate = birthDate;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.interest = interest;
		this.bodyFat = bodyFat;
		this.fitnessLevel = fitnessLevel;
		this.activityLeval = activityLeval;
		this.foodPreference = foodPreference;
		this.goals = goals;
		this.startTimeT = startTimeT;
		this.endTimeT = endTimeT;
		this.startTime = startTime;
		this.endTime = endTime;
		this.enrollment = enrollment;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhoneNumber() {
		return custPhoneNumber;
	}

	public void setCustPhoneNumber(String custPhoneNumber) {
		this.custPhoneNumber = custPhoneNumber;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public double getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(double bodyFat) {
		this.bodyFat = bodyFat;
	}

	public String getFitnessLevel() {
		return fitnessLevel;
	}

	public void setFitnessLevel(String fitnessLevel) {
		this.fitnessLevel = fitnessLevel;
	}

	public String getActivityLeval() {
		return activityLeval;
	}

	public void setActivityLeval(String activityLeval) {
		this.activityLeval = activityLeval;
	}

	public String getFoodPreference() {
		return foodPreference;
	}

	public void setFoodPreference(String foodPreference) {
		this.foodPreference = foodPreference;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	

	public LocalTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}



	public LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public String getStartTimeT() {
		return startTimeT;
	}



	public void setStartTimeT(String startTimeT) {
		this.startTimeT = startTimeT;
	}



	public String getEndTimeT() {
		return endTimeT;
	}



	public void setEndTimeT(String endTimeT) {
		this.endTimeT = endTimeT;
	}



	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	

@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custPhoneNumber=" + custPhoneNumber
				+ ", custEmail=" + custEmail + ", address=" + address + ", birthDate=" + birthDate + ", age=" + age
				+ ", gender=" + gender + ", height=" + height + ", weight=" + weight + ", interest=" + interest
				+ ", bodyFat=" + bodyFat + ", fitnessLevel=" + fitnessLevel + ", activityLeval=" + activityLeval
				+ ", foodPreference=" + foodPreference + ", goals=" + goals + ", startTimeT=" + startTimeT
				+ ", endTimeT=" + endTimeT + ", startTime=" + startTime + ", endTime=" + endTime + ", enrollment="
				+ enrollment + "]";
	}



public void AddEnrollment(Enrollment e)
{
	enrollment=e;
	e.setCustomer(this);
}

public void removeEnrollment(Enrollment e)
{
	enrollment=null;
	e.setCustomer(this);
}

public void addAddress(Address a)
{
	address=a;
	a.setCustomer(this);
}

public void removeAddress(Address a)
{
	address=null;
	a.setCustomer(this);
}

}
