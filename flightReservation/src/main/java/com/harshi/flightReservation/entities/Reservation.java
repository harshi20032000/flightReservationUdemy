package com.harshi.flightReservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Reservation extends AbstractEntity {
	private Boolean checkedIn;
	private int numOfBags;
	@Override
	public String toString() {
		 return "Reservation Details:\n" +
		           "Checked In: " + checkedIn + "\n" +
		           "Number of Bags: " + numOfBags + "\n" +
		           "Passenger: " + passenger + "\n" +
		           "Flight: " + flight;
		}
	@OneToOne
	private Passenger passenger;
	@OneToOne
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
}
