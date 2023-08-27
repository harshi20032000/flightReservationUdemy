package com.harshi.flightReservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
