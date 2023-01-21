package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.LoginDto;
import com.masai.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginServiceHandler {
	
	@Autowired
	private LoginService loginSer;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdminHandler(@RequestBody LoginDto dto) throws LoginException{
		
		String result = loginSer.loginAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	@PostMapping("/logout")
	public String logoutAdminHandler(@RequestParam(required = false) String key) throws LoginException {
		
		return loginSer.LogOutFromAccount(key);
		
	}
	
	

}
