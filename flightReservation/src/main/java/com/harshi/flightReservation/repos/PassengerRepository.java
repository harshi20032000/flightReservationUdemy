package com.harshi.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshi.flightReservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
