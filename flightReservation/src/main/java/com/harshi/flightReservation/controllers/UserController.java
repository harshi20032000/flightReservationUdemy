package com.harshi.flightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshi.flightReservation.entities.User;
import com.harshi.flightReservation.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage() on UserController");
		return "login/registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register() for user " + user+ "on UserController");
		userRepository.save(user);
		LOGGER.info("Redirecting to login.html on UserController");
		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside to showLoginPage() on UserController");
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("Inside showLoginPage() with email - " + email+"on UserController");
		User user = userRepository.findByEmail(email);
		if (user.getPassword().equals(password)) {
			LOGGER.info("Redirecting to findFlights.html on UserController");
			return "login/findFlights";
		} else
			modelMap.addAttribute("msg", "Invalid username/password. Try Again");
		LOGGER.info("Redirecting to login.html on UserController");
		return "login/login";
	}
}
