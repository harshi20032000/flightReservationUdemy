package com.harshi.checkIn.integration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harshi.checkIn.integration.dto.Reservation;
import com.harshi.checkIn.integration.dto.ReservationUpdateDTO;

@Service
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String FLIGHTRESERVATION_URL = "http://localhost:8085/flightreservation/reservations/";

	@Override
	public Reservation findResrvation(Long id) {
		RestTemplate restTemplate= new RestTemplate();
		Reservation reservation = restTemplate.getForObject(FLIGHTRESERVATION_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateDTO updateRequest) {
		RestTemplate restTemplate= new RestTemplate();
		Reservation reservation = restTemplate.postForObject(FLIGHTRESERVATION_URL, updateRequest, Reservation.class);
		return reservation;
	}

}
