package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;
import com.masai.repository.CustomerRepo;
import com.masai.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		if(order!=null) {
			OrderDetails savedOrder=	orderRepo.save(order);
			return savedOrder;
		}
		else {
			throw new OrderException("Order Not Added.....!");
		}
	
	
	}

	@Override
	public OrderDetails removeOrder(Integer OrderId) throws OrderException {
		
		
		Optional<OrderDetails> opt = orderRepo.findById(OrderId);
		if (opt.isPresent()) {
			OrderDetails deletedOrder = opt.get();
			orderRepo.delete(deletedOrder);
			return deletedOrder;
		} else {
			throw new OrderException("Order does not exist...!");
		}
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = orderRepo.findById(order.getOrderId());
		if (opt.isPresent()) {
			OrderDetails updatedorder = opt.get();
			return orderRepo.save(updatedorder);
			
			 
		} else {
			throw new OrderException("Order does not exist...!");
		}
	}

	@Override
	public OrderDetails viewOrder(Integer OrderId) throws OrderException {
		Optional<OrderDetails> opt = orderRepo.findById(OrderId);
		if (opt.isPresent()) {
			OrderDetails vieworder = opt.get();
			return vieworder;
		} else {
			throw new OrderException("Order does not exist...!");
		}
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
