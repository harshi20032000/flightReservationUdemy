package com.harshi.flightReservation.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface SecurityService {
	boolean login(String username, String password, HttpServletRequest req, HttpServletResponse res);
}
