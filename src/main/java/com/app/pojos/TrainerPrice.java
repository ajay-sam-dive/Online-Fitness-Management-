package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrainerPrice {

	@Column(nullable=true)
	private double  threeMonthPrice;
	
	@Column(nullable = true)
	private double  sixMonthPrice;

	public TrainerPrice(double threeMonthPrice, double sixMonthPrice) {
		super();
		this.threeMonthPrice = threeMonthPrice;
		this.sixMonthPrice = sixMonthPrice;
	}

	public double getThreeMonthPrice() {
		return threeMonthPrice;
	}

	public void setThreeMonthPrice(double threeMonthPrice) {
		this.threeMonthPrice = threeMonthPrice;
	}

	public double getSixMonthPrice() {
		return sixMonthPrice;
	}

	public void setSixMonthPrice(double sixMonthPrice) {
		this.sixMonthPrice = sixMonthPrice;
	}

	@Override
	public String toString() {
		return "TrainerPrice [threeMonthPrice=" + threeMonthPrice + ", sixMonthPrice=" + sixMonthPrice + "]";
	}
	
	
}
