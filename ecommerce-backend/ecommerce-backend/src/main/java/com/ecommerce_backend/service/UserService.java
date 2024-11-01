package com.ecommerce_backend.service;

import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.exception.UserException;

public interface UserService {

	public User findUserById(Long userId)throws UserException;
	
	public User findUserProfileByJwt(String jwt)throws UserException;
	
	
}
