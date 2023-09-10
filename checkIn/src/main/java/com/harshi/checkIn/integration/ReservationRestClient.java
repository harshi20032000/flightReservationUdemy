package com.harshi.checkIn.integration;

import com.harshi.checkIn.integration.dto.Reservation;
import com.harshi.checkIn.integration.dto.ReservationUpdateDTO;

public interface ReservationRestClient {
	
	public Reservation findResrvation(Long id);
	
	public Reservation updateReservation(ReservationUpdateDTO updateRequest);

}
