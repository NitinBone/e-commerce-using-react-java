package com.ecommerce_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.config.JwtProvider;
import com.ecommerce_backend.exception.UserException;
import com.ecommerce_backend.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserById(Long userId) throws UserException {
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("user not found with id :"+userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email=jwtProvider.getEmailFromToken(jwt);
		User user =userRepository.findByEmail(email);
		
		if(user==null) {
			throw new UserException("user not found with email"+email);
		}
		return user;
	}

}
