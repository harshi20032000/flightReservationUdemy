package com.harshi.checkIn.integration.dto;

public class Reservation{
	private Long id;
	private Boolean checkedIn;
	private int numOfBags;
	@Override
	public String toString() {
		return "Reservation \n\t[checkedIn=" + checkedIn + ", \n\tnumOfBags=" + numOfBags + ", \n\tpassenger=" + passenger
				+ ", \n\tflight=" + flight + "]";
	}
	
	private Passenger passenger;
	
	private Flight flight;
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumOfBags() {
		return numOfBags;
	}
	public void setNumOfBags(int numOfBags) {
		this.numOfBags = numOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
