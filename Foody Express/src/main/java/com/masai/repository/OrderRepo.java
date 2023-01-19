package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.OrderDetails;

public interface OrderRepo extends JpaRepository<OrderDetails, Integer>{
	
	

}
