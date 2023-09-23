package com.harshi.flightReservation.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User Details:\n" +
		           "First Name: " + firstName + "\n" +
		           "Last Name: " + lastName + "\n" +
		           "Email: " + email;
		}

}
