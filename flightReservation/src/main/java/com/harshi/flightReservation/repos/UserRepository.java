package com.harshi.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshi.flightReservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
