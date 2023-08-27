package com.harshi.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshi.flightReservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
