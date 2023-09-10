package com.harshi.flightReservation.controllers;

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
	
	
	@RequestMapping(value="/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "login/completeReservation";}
	
	
	@RequestMapping(value="/completeReservation")
	public String completeReservation(@ModelAttribute Passenger passenger,Long flightId, ModelMap modelMap) {
		Flight flightToBook = flightRepository.findById(flightId).get();
		Reservation bookedFlight = reservationService.bookFlight(passenger, flightToBook);
		modelMap.addAttribute("msg", "Reservation done succesfully");
		modelMap.addAttribute("reservation", bookedFlight);
		return "login/reservationConfirmationSummary";
		
	}

}
