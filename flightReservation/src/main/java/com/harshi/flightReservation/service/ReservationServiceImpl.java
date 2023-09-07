package com.harshi.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.entities.Passenger;
import com.harshi.flightReservation.entities.Reservation;
import com.harshi.flightReservation.repos.PassengerRepository;
import com.harshi.flightReservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(Passenger passenger, Flight flight) {
		Reservation reservation = new Reservation();
		reservation.setPassenger(passengerRepository.save(passenger));
		reservation.setFlight(flight);
		/** Reservation will be checkedIn when the passenger checksIn
		 * also number of bags will be set at that time */
		reservation.setCheckedIn(false);
		return reservationRepository.save(reservation);
	}

}
