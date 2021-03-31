package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DietPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dietId;
	
	private String Breakfast;
	
	private String lunch;
	
	private String dinner;
	
	@OneToOne
	@JoinColumn(name="enrollmentId")
	private Enrollment enrollment;

	public DietPlan() {
	System.out.println("in ctor of"  +getClass().getName());
	}
	
	public DietPlan( String breakfast, String lunch, String dinner) {
		super();
		Breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}

	public Integer getDietId() {
		return dietId;
	}

	public void setDietId(Integer dietId) {
		this.dietId = dietId;
	}

	public String getBreakfast() {
		return Breakfast;
	}

	public void setBreakfast(String breakfast) {
		Breakfast = breakfast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return "DietPlan [dietId=" + dietId + ", Breakfast=" + Breakfast + ", lunch=" + lunch + ", dinner=" + dinner
				+ "]";
	}
	
	
	
}
