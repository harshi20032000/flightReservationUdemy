package com.harshi.flightReservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Reservation extends AbstractEntity {
	private Boolean checkedIn;
	private int numOfBags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
}
