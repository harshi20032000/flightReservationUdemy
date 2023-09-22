package com.harshi.flightReservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshi.flightReservation.controllers.UserController;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Override
	public Reservation bookFlight(Passenger passenger, Flight flight) {
		LOGGER.info("Inside bookFlight() on ReservationServiceImpl");
		Reservation reservation = new Reservation();
		reservation.setPassenger(passengerRepository.save(passenger));
		reservation.setFlight(flight);
		/** Reservation will be checkedIn when the passenger checksIn
		 * also number of bags will be set at that time */
		reservation.setCheckedIn(false);
		Reservation savedReservation= reservationRepository.save(reservation);
		LOGGER.info("Reservation saved - "+ reservation);
		String filepath = "C:\\Users\\Admin\\Documents\\Itinerary"+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filepath);
		emailUtil.sendItinerary(passenger.getEmail(), filepath );
		LOGGER.info("Itinerary generated for Reservation with id - "+ savedReservation.getId());
		return savedReservation;
	}

	@Override
	public Reservation getFlight(Long id) {
		LOGGER.info("Inside getFlight() on ReservationServiceImpl with flight id - "+id);
		return reservationRepository.findById(id).get();
	}

	@Override
	public Reservation updateFlight(ReservationUpdateDTO reservationUpdateRequest) {
		LOGGER.info("Inside updateFlight() on ReservationServiceImpl for reservation id - "+reservationUpdateRequest.getId());
		Reservation reservationToUpdate = reservationRepository.findById(reservationUpdateRequest.getId()).get();
		LOGGER.info("Inside updateFlight() returned Reservation - "+reservationToUpdate);
		reservationToUpdate.setCheckedIn(reservationUpdateRequest.isCheckedIn());
		reservationToUpdate.setNumOfBags(reservationUpdateRequest.getNumOfBags());
		Reservation updatedReservation = reservationRepository.save(reservationToUpdate);
		LOGGER.info("Inside updateFlight() saved Reservation - "+reservationToUpdate);
		String filepath = "C:\\Users\\Admin\\Documents\\Itinerary\\reservationUpdated"+updatedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(updatedReservation, filepath);
		emailUtil.sendItinerary(updatedReservation.getPassenger().getEmail(), filepath );
		LOGGER.info("Itinerary generated for Reservation with id - "+ updatedReservation.getId());
		return updatedReservation;
	}

}
