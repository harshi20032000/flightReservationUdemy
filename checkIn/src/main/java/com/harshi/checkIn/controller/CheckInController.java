package com.harshi.checkIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshi.checkIn.integration.ReservationRestClient;
import com.harshi.checkIn.integration.dto.Reservation;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient reservationRestClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckIn() {
		return "startCheckin";
	}
	
	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap model) {
		Reservation reservation = reservationRestClient.findResrvation(reservationId);
		model.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

}
