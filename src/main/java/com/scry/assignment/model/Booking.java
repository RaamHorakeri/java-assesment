package com.scry.assignment.model;

import java.time.LocalDateTime;

public class Booking {	
	private String id;
	private String hallName;
	private String capacity;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public Booking(String id, String hallName, String capacity, LocalDateTime startTime, LocalDateTime endTime) {
		this.id = id;
		this.hallName = hallName;
		this.capacity = capacity;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	 
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getHallName() {
		return hallName;
	}
	
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", hallName=" + hallName + ", capacity=" + capacity + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}
