package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.service.OrderDetailService;


@RestController
@RequestMapping("/order")
public class OrderDetailsController {

	@Autowired
	private OrderDetailService orderService;

	@PostMapping("/add")
	public ResponseEntity<OrderDetails> saveOrderDetailsHandler(@RequestBody OrderDetails order) {
		
		OrderDetails savedOrder = orderService.addOrder(order);
		
		return new ResponseEntity<OrderDetails>(savedOrder, HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/update")
	public ResponseEntity<OrderDetails>  updateOrderHandler(@RequestBody OrderDetails order){
		
		OrderDetails updatedOrderDetails = orderService.updateOrder(order);
		
		return new ResponseEntity<OrderDetails>(updatedOrderDetails, HttpStatus.OK);
		
	}

	@DeleteMapping("/remove/{orderId}")
	public ResponseEntity<OrderDetails> removeOrderHandler(@PathVariable("orderId") Integer OrderId){
		
		OrderDetails deletedOrderDetails = orderService.removeOrder(OrderId);
		
		return new ResponseEntity<OrderDetails>(deletedOrderDetails, HttpStatus.OK);
		
	}

	@GetMapping("/view/{orderId}")
	public ResponseEntity<OrderDetails> viewOrderDetails(@PathVariable("orderId")  Integer OrderId ){
		
		OrderDetails orderDetails = orderService.viewOrder(OrderId);
		
		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
		
	}
	
	@GetMapping("/listOfOrder")
	public ResponseEntity<List<OrderDetails>> viewAllOrdersByCustomerHandler(@RequestBody Customer customer){
		
		List<OrderDetails> orderDetail = orderService.viewAllOrders(customer);
		
		return new ResponseEntity<List<OrderDetails>>(orderDetail,HttpStatus.ACCEPTED);
		
	}

}
