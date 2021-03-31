package com.app.pojos;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class TrainerSchedule {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scheduleId;
	private String days;
	
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime startTime;
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime endTime;
	
	@OneToOne
	@JoinColumn(name="TrainerId")
	private Trainer trainer;
	
	public TrainerSchedule() {
		// TODO Auto-generated constructor stub
	}

	public TrainerSchedule(String days, LocalTime startTime, LocalTime endTime, Trainer trainer) {
		super();
		
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
		this.trainer = trainer;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
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

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "TrainerSchedule [scheduleId=" + scheduleId + ", days=" + days + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
	
}
