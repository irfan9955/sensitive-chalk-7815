package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
import com.masai.model.FoodCart;

@Repository
public interface CartRepository extends JpaRepository<FoodCart, Integer> {

	public FoodCart findByCustomer(Customer customer);
	
}
