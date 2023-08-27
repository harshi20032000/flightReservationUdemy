package com.harshi.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshi.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
