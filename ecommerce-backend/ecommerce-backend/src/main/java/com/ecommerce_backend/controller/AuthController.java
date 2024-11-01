package com.ecommerce_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.config.JwtProvider;
import com.ecommerce_backend.exception.UserException;
import com.ecommerce_backend.repository.UserRepository;
import com.ecommerce_backend.request.LoginRequest;
import com.ecommerce_backend.responce.AuthResponce;
import com.ecommerce_backend.service.CustomeUserServiceImplementation;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	private final PasswordEncoder passwordEncoder;
	private final CustomeUserServiceImplementation customeUserService;


	@Autowired
	public AuthController(UserRepository userRepository,
	                      CustomeUserServiceImplementation customeUserService,
	                      PasswordEncoder passwordEncoder,
	                      JwtProvider jwtProvider) {
	    this.userRepository = userRepository;
	    this.customeUserService = customeUserService;
	    this.passwordEncoder = passwordEncoder;
	    this.jwtProvider = jwtProvider;
	}


	@PostMapping("/signup")
	public ResponseEntity<AuthResponce>createuserHandler(@RequestBody User user)throws UserException{
		
		String email=user.getEmail();
		String password=user.getPassword();
		String firstName=user.getFirstName();
		String lastName=user.getLastName();
		
		User isEmailExist=userRepository.findByEmail(email);
		
		if(isEmailExist!=null) {
			throw new UserException("Email is Already Used With Another Account");
		}
		
		User createdUser=new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);
		
		User savedUser=userRepository.save(createdUser);
		
		Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token=jwtProvider.generateToken(authentication);
		
		AuthResponce authResponce=new AuthResponce();
		authResponce.setJwt(token);
		authResponce.setMessage("signup success");
		
		return new ResponseEntity<AuthResponce>(authResponce,HttpStatus.CREATED);
		
		
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponce>loginUserHandler(@RequestBody LoginRequest loginRequest){
		
		String username=loginRequest.getEmail();
		String password=loginRequest.getPassword();
		
		Authentication authentication=authenticate(username,password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
        String token=jwtProvider.generateToken(authentication);
		
        AuthResponce authResponce=new AuthResponce();
        authResponce.setJwt(token);
        authResponce.setMessage("signup success");		
		return new ResponseEntity<AuthResponce>(authResponce,HttpStatus.CREATED);
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails=customeUserService.loadUserByUsername(username);
		if(userDetails==null) {
			throw new BadCredentialsException("invalid Username");
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("invalid password..");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
	
	

}
