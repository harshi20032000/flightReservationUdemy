package com.harshi.flightReservation.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Passenger extends AbstractEntity {
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String middleName;
	private String lastName;
	private String email;
	private String phone;
}
