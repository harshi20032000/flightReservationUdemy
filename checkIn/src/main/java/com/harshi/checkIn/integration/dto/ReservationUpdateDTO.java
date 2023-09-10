package com.harshi.checkIn.integration.dto;

public class ReservationUpdateDTO {
	private Long id;
	private int numOfBags;
	private Boolean checkedIn;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumOfBags() {
		return numOfBags;
	}
	public void setNumOfBags(int numOfBags) {
		this.numOfBags = numOfBags;
	}
	public Boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	

}
