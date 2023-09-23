package com.harshi.flightReservation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.entities.Passenger;
import com.harshi.flightReservation.entities.Reservation;
import com.harshi.flightReservation.repos.FlightRepository;
import com.harshi.flightReservation.service.ReservationService;
@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/showAllReservations")
	public String showAllReservations(ModelMap modelMap) {
		List<Reservation> reservations = reservationService.getReservations();
		modelMap.addAttribute("reservations", reservations);
		return "login/showAllReservations";
	}
	
	@RequestMapping(value="/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() on ReservationController with flightId - "+flightId);
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Redirecting to completeReservation.html on ReservationController");
		return "login/completeReservation";}
	
	
	@RequestMapping(value="/completeReservation")
	public String completeReservation(@ModelAttribute Passenger passenger,Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() on ReservationController with flightId - "+flightId);
		Flight flightToBook = flightRepository.findById(flightId).get();
		Reservation bookedFlight = reservationService.bookFlight(passenger, flightToBook);
		modelMap.addAttribute("msg", "Reservation done succesfully");
		modelMap.addAttribute("reservation", bookedFlight);
		LOGGER.info("Redirecting to reservationConfirmationSummary.html on ReservationController");
		return "login/reservationConfirmationSummary";
		
	}

}
