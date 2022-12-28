package com.te.ecommerce.ecommercebase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.ecommercebase.dto.LoginDto;
import com.te.ecommerce.ecommercebase.response.AppResponse;
import com.te.ecommerce.ecommercebase.security.JwtUtil;
import com.te.ecommerce.ecommercebase.services.UserService;

@RestController
@RequestMapping("/auth/user")
public class LoginContoller {

	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
	public ResponseEntity<AppResponse> loginUser(@RequestBody LoginDto loginDto){
		
		return
	}
	
	
	