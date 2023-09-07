package com.harshi.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harshi.flightReservation.dto.ReservationUpdateDTO;
import com.harshi.flightReservation.entities.Reservation;
import com.harshi.flightReservation.service.ReservationService;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationService reservationService;

	@RequestMapping(value="/reservations/{id}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable("id") Long id) {
		return reservationService.getFlight(id);
	}

	@RequestMapping(value="/reservations", method = RequestMethod.POST)
	public Reservation updateReservation(@RequestBody ReservationUpdateDTO reservationUpdateRequest) {
		return reservationService.updateFlight(reservationUpdateRequest);
	}

}
