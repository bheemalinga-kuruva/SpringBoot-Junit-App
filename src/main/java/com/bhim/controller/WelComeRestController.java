package com.bhim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhim.service.WelComeservice;

@RestController
public class WelComeRestController {
	
	@Autowired
	private WelComeservice welcomeservice;
	@GetMapping("/welcome")
	public   ResponseEntity<String> welcomeMsg() {
		String response = welcomeservice.welcome();
		String str="Welcome to karnataka";
		if(str.equals(response)) {
			return new ResponseEntity<>( response, HttpStatus.CREATED);
		}
		return  new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
		   
	}

}
