package com.bhim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bhim.binding.LoginRequest;
import com.bhim.model.UserDetailes;
import com.bhim.reposiotary.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String saveUser(UserDetailes request) {
		userRepository.save(request);
		return "USER ADDED";
	}

	@Override
	public UserDetailes getUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetailes> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateUser(Integer userId, UserDetailes request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
		public   UserDetailes validateUserCredentials(LoginRequest loginRequest) {
	        if (loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required");
	        }

	        UserDetailes user = null;

	        if (loginRequest.getEmail() != null) {
	            user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
	        } else if (loginRequest.getUserName() != null) {
	            user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
	        } else if (loginRequest.getPhoneNumber() != null) {
	            user = userRepository.findByPhoneNumberAndPassword(loginRequest.getPhoneNumber(), loginRequest.getPassword());
	        } else {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one identifier (email, username, or phone number) is required");
	        }

	        if (user == null) {
	            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
	        }

	        return user;
	    }
}
