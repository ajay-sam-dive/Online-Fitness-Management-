package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table
public class Admin {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	@Column(length = 20)
	private String adminName;
	
	@Column(length = 20,unique =true)
	@Email
	private String adminEmail;
	@Column(length = 20,nullable = false)
	private String adminPassword;
	@Length(min = 10,max = 10)
	@Column(unique = true)
	private String adminPhoneNumber;
	
	
	public Admin() {
	System.out.println("in ctor of "+getClass().getName());
	}


	public Admin(String adminName, @Email String adminEmail, String adminPassword,
			@Length(min = 10, max = 10) String adminPhoneNumber) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminPhoneNumber = adminPhoneNumber;
	}


	public Integer getAdminId() {
		return adminId;
	}


	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminEmail() {
		return adminEmail;
	}


	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}


	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPhoneNumber=" + adminPhoneNumber + "]";
	}

	
}
