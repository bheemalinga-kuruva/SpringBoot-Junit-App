package com.bhim.service;

import java.util.List;

import com.bhim.binding.LoginRequest;
import com.bhim.model.UserDetailes;

public interface UserService {

	String saveUser(UserDetailes request);

	UserDetailes getUser(Integer userId);

	List<UserDetailes> getAllUsers();

	String deleteUser(Integer userId);

	String UpdateUser(Integer userId, UserDetailes request);

	UserDetailes validateUserCredentials(LoginRequest loginRequest);

}
