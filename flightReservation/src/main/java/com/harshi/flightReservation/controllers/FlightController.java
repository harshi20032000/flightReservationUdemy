package com.harshi.flightReservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/showLanding")
	public String showLanding() {
		LOGGER.info("Inside showLanding() on FlightController");
		return "login/landing";
	}
	@RequestMapping("/showfindFlights")
	public String showfindFlights() {
		LOGGER.info("Inside showLanding() on FlightController");
		return "login/findFlights";
	}
	
	@RequestMapping(value = "/findFlights", method=RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to")String to, @RequestParam("dateOfDeparture") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfDeparture, ModelMap modelMap) {
		LOGGER.info("Inside findFlights() on FlightController");
		List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Redirecting to displayFlights.html on flightController");
		return "login/displayFlights";
		}
	@RequestMapping("admin/showFlight")
	public String showAddFlight() {
		return "addFlight";
	}
	
}
