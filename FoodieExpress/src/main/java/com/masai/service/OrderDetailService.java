package com.masai.service;

import java.util.List;

import com.masai.exception.FoodCartException;
import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;

public interface OrderDetailService {
	
	public OrderDetails addOrder(OrderDetails order) throws OrderException;

	public OrderDetails removeOrder(Integer OrderId) throws OrderException;

	public OrderDetails updateOrder(OrderDetails order) throws OrderException;

	public OrderDetails viewOrder(Integer OrderId) throws OrderException;

//	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException;

	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException,FoodCartException;

}
