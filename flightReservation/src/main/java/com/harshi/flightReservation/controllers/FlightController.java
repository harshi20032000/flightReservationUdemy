package com.harshi.flightReservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.repos.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping(value = "/findFlights", method=RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to")String to, @RequestParam("dateOfDeparture") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfDeparture, ModelMap modelMap) {
		List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
		modelMap.addAttribute("flights", flights);
		return "login/displayFlights";
		
	}
}
