package com.harshi.flightReservation.service;

import java.util.List;

import com.harshi.flightReservation.dto.ReservationUpdateDTO;
import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.entities.Passenger;
import com.harshi.flightReservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(Passenger passenger, Flight flight);

	public Reservation getFlight(Long id);

	public Reservation updateFlight(ReservationUpdateDTO reservationUpdateRequest);

	public List<Reservation> getReservations();

}
