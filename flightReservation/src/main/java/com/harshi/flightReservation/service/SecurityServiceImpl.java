package com.harshi.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepo;

	@Override
	public boolean login(String username, String password, HttpServletRequest req, HttpServletResponse res) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(authenticationToken);
		boolean isAuthenticated = authenticationToken.isAuthenticated();
		if(isAuthenticated) {
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(authenticationToken);
			securityContextRepo.saveContext(context, req, res);
		}
		return isAuthenticated;
	}

}
