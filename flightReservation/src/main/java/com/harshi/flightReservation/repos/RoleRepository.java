package com.harshi.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshi.flightReservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
