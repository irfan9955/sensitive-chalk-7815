package com.masai.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepositoryImplementation<Customer, Integer>{

	public Customer findByEmail(String email);

	public Customer findByMobileNumber(String mobileNo);
	
}
