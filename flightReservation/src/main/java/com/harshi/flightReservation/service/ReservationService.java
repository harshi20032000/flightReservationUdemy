package com.harshi.flightReservation.service;

import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.entities.Passenger;
import com.harshi.flightReservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(Passenger passenger, Flight flight);

}
