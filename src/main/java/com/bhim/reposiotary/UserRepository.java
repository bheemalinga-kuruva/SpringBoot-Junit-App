package com.bhim.reposiotary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhim.model.UserDetailes;

public interface UserRepository extends JpaRepository<UserDetailes, Integer> {

	UserDetailes findByEmailAndPassword(String email, String password);
	UserDetailes findByUserNameAndPassword(String username, String password);
	UserDetailes findByPhoneNumberAndPassword(Long phoneNumber, String password);
}
