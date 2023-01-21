package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.LoginDto;

public interface LoginService {
	
	public String loginAccount(LoginDto dto) throws LoginException;
	
	public String LogOutFromAccount(String key) throws LoginException;

}
