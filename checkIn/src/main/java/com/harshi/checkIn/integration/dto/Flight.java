package com.harshi.checkIn.integration.dto;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;


public class Flight {
	private Long id;
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOperatingAirlines() {
		return operatingAirlines;
	}
	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}
	@Override
	public String toString() {
		return "Flight \n\t[flightNumber=" + flightNumber + ", \n\toperatingAirlines=" + operatingAirlines + ", \n\tdepartureCity="
				+ departureCity + ", \n\tarrivalCity=" + arrivalCity + ", \n\testimatedDepartureTime=" + estimatedDepartureTime + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
