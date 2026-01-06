package com.example.jwtAuthentication.config;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	
	private  JwtService jwtService;
	private UserDetailsService userDetailsService;
	
	
//	public JwtAuthenticationFilter(JwtService jwtService) {
//		super();
//		this.jwtService = jwtService;
//	}


	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		final String authenticationHeader = request.getHeader("Authorization");
		final String jwt;
		final String userEmail;
		if(authenticationHeader == null || !authenticationHeader.startsWith("Bearer "))
		{
			filterChain.doFilter(request, response);
			return ;
		}
		
		jwt = authenticationHeader.substring(7);
		userEmail = jwtService.extractUsername(jwt);
		
		if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null)
		{
			UserDetails userDetails = this.userDetailsService.loadByUsername(userEmail)
		}
		
		
	}
	
};