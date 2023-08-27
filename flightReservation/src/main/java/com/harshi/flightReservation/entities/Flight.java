package com.harshi.flightReservation.entities;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Flight extends AbstractEntity{
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
}
