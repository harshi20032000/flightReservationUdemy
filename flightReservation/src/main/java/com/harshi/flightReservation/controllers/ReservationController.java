package com.harshi.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.entities.Passenger;
import com.harshi.flightReservation.repos.FlightRepository;
@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	
	@RequestMapping(value="/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "login/completeReservation";}
	
	
	@RequestMapping(value="/completeReservation")
	public String completeReservation(@ModelAttribute Passenger passenger,Long flightId) {
		String name=passenger.getFirstName()+" "+passenger.getLastName();
		String email = passenger.getEmail();
		return "login/showReservation";
		
	}

}
