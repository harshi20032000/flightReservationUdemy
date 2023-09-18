package com.harshi.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshi.flightReservation.dto.ReservationUpdateDTO;
import com.harshi.flightReservation.entities.Flight;
import com.harshi.flightReservation.entities.Passenger;
import com.harshi.flightReservation.entities.Reservation;
import com.harshi.flightReservation.repos.PassengerRepository;
import com.harshi.flightReservation.repos.ReservationRepository;
import com.harshi.flightReservation.util.EmailUtil;
import com.harshi.flightReservation.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PdfGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(Passenger passenger, Flight flight) {
		Reservation reservation = new Reservation();
		reservation.setPassenger(passengerRepository.save(passenger));
		reservation.setFlight(flight);
		/** Reservation will be checkedIn when the passenger checksIn
		 * also number of bags will be set at that time */
		reservation.setCheckedIn(false);
		Reservation savedReservation= reservationRepository.save(reservation);
		String filepath = "C:\\Users\\Admin\\Documents\\Itinerary"+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filepath);
		emailUtil.sendItinerary(passenger.getEmail(), filepath );
		return savedReservation;
	}

	@Override
	public Reservation getFlight(Long id) {
		return reservationRepository.findById(id).get();
	}

	@Override
	public Reservation updateFlight(ReservationUpdateDTO reservationUpdateRequest) {
		Reservation reservationToUpdate = reservationRepository.findById(reservationUpdateRequest.getId()).get();
		reservationToUpdate.setCheckedIn(reservationUpdateRequest.isCheckedIn());
		reservationToUpdate.setNumOfBags(reservationUpdateRequest.getNumOfBags());
		Reservation updatedReservation = reservationRepository.save(reservationToUpdate);
		String filepath = "C:\\Users\\Admin\\Documents\\Itinerary\\reservationUpdated"+updatedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(updatedReservation, filepath);
		emailUtil.sendItinerary(updatedReservation.getPassenger().getEmail(), filepath );
		return updatedReservation;
	}

}
