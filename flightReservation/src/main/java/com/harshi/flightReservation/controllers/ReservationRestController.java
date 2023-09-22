package com.harshi.flightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value="/reservations/{id}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside getReservation() on ReservationRestController with reservationId - "+id);
		return reservationService.getFlight(id);
	}

	@RequestMapping(value="/reservations/", method = RequestMethod.POST)
	public Reservation updateReservation(@RequestBody ReservationUpdateDTO reservationUpdateRequest) {
		LOGGER.info("Inside updateReservation() on ReservationRestController with reservationId - "+reservationUpdateRequest.getId());
		return reservationService.updateFlight(reservationUpdateRequest);
	}

}
