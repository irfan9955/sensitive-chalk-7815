package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FoodCartException;
import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.FoodCart;
import com.masai.model.OrderDetails;
import com.masai.repository.CartRepository;
import com.masai.repository.OrderDetailRepo;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	private OrderDetailRepo orderDetailRepo;
	
	
	@Autowired
	private CartRepository cartRepo;
	
	
	

//	@Autowired
//	private CustomerRepo customerRepo;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		if(order!=null) {
			OrderDetails savedOrder=	orderDetailRepo.save(order);
			return savedOrder;
		}
		else {
			throw new OrderException("Order Not Added.....!");
		}
	
	
	}

	@Override
	public OrderDetails removeOrder(Integer OrderId) throws OrderException {
		
		
		Optional<OrderDetails> opt = orderDetailRepo.findById(OrderId);
		
		if (opt.isPresent()) {
			
			OrderDetails deletedOrder = opt.get();
			
			orderDetailRepo.delete(deletedOrder);
			
			return deletedOrder;
			
		} else {
			throw new OrderException("Order does not exist...!");
		}
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		
		Optional<OrderDetails> opt = orderDetailRepo.findById(order.getOrderId());
		
		if (opt.isPresent()) {
			
			return orderDetailRepo.save(order);
			
			 
		} else {
			
			throw new OrderException("Order does not exist...!");
			
		}
	}

	@Override
	public OrderDetails viewOrder(Integer OrderId) throws OrderException {
		
		Optional<OrderDetails> opt = orderDetailRepo.findById(OrderId);
		
		if (opt.isPresent()) {
			
			OrderDetails vieworder = opt.get();
			
			return vieworder;
			
		} else {
			
			throw new OrderException("Order does not exist...!");
			
		}
	}

//	@Override
//	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException {
//			       
//		
//		Optional<Restaurant>  rest= restRepo.findById(res.getRestaurantId());
//		
//		List<Item> items = rest.get().getItems();
//		
//		
//		
//		
//		
//		
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException,FoodCartException {
		// TODO Auto-generated method stub
		
		FoodCart foodCart = cartRepo.findByCustomer(customer);
		
		if(foodCart==null) {
			throw new FoodCartException("FoodCart not found....");
		}
		
		List<OrderDetails> orderdetail =orderDetailRepo.findByCart(foodCart);
		
		if(orderdetail.size()==0) {
			throw new OrderException("Order Detail Not found....");
		}
		
		
		
		return orderdetail;
	}

	

	

}
