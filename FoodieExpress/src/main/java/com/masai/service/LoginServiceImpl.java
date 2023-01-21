package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentLoginSession;
import com.masai.model.Customer;
import com.masai.model.LoginDto;
import com.masai.model.LoginType;
import com.masai.model.Restaurant;
import com.masai.repository.CustomerRepo;
import com.masai.repository.RestaurantDao;
import com.masai.repository.SessionRepo;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService{
 
	@Autowired
	private SessionRepo sesRepo;
	
	@Autowired
	private CustomerRepo cusRepo;
	
	@Autowired
	private RestaurantDao resRepo;
	
	@Override
	public String loginAccount(LoginDto dto) throws LoginException {
		// TODO Auto-generated method stub
		
		if(dto.getLoginType().equals(LoginType.CUSTOMER)) {
			
			Customer customer =cusRepo.findByMobileNumber(dto.getMobileNo());
			
			if(customer == null) {
				throw new LoginException("Please enter Valid Mobile Number....");
			}
			
			Optional<CurrentLoginSession> currentloginsession =sesRepo.findById(customer.getCustomerId());
			
			if(currentloginsession.isPresent()) {
				throw new LoginException("Customer Already Logged in....");
			}
			
			if(customer.getPassword().equals(dto.getPassword())) {
				
				String key = RandomString.make(6);
				
				CurrentLoginSession currloginsession2 = new CurrentLoginSession(customer.getCustomerId(), key, LocalDateTime.now());
				
				CurrentLoginSession cls =sesRepo.save(currloginsession2);
				
				return cls.toString() +"\n Customer login Successfull......";
				
			}
			else {
				throw new LoginException("please Enter valid password...");
			}
			
			
		}
		else if(dto.getLoginType().equals(LoginType.RESTAURANT)) {
			
			Restaurant restaurant = resRepo.findByMobileNumber(dto.getMobileNo());
			
			if(restaurant == null) {
				throw new LoginException("Please enter valid mobile Number...");
			}
			
			
			Optional<CurrentLoginSession> currentloginsession =sesRepo.findById(restaurant.getRestaurantId());
			
			
			if(currentloginsession.isPresent()) {
				throw new LoginException("Restaurant already login....");
			}
			
			
			if(restaurant.getPassword().equals(dto.getPassword())) {
				
				String key = RandomString.make(6);
				
				CurrentLoginSession currentloginSession2 = new CurrentLoginSession(restaurant.getRestaurantId(), key, LocalDateTime.now());
				
				CurrentLoginSession  cur =sesRepo.save(currentloginSession2);
				
				return cur.toString()+"\n   Restauran login successfully....";
				
			}
			else {
				throw new LoginException("please enter valid password...");
			}
			
			
		}
		else {
			throw new LoginException("Please Choose CUSTOMER OR RESTAURANT....");
			
			
		}
		
		
		
		
		
		
		
	}

	@Override
	public String LogOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		
		
		CurrentLoginSession currentloginsession = sesRepo.findByUuid(key);
		
		if(currentloginsession==null) {
			throw new LoginException("user not Logged In with this number");
		}
		
		
		sesRepo.delete(currentloginsession);
		
		
		return "logged Out!";
	}

	
	
}
