package com.bhim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhim.binding.LoginRequest;
import com.bhim.model.UserDetailes;
import com.bhim.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveuser")
	public ResponseEntity<String> addUser(@RequestBody UserDetailes request) {
		String response = userService.saveUser(request);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else
			return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
    public UserDetailes login(@RequestBody LoginRequest loginRequest) {
        return userService.validateUserCredentials(loginRequest);
    }
}
