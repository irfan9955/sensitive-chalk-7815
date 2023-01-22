package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerNotFound;
import com.masai.exception.FoodCartException;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.service.CartService;

@RestController("/cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/createFoodCart/{customerId}")
	public ResponseEntity<FoodCart> addNewFoodCartHandler(@PathVariable Integer customerId,@Valid @RequestBody FoodCart foodCart) throws FoodCartException, CustomerNotFound{
		
		FoodCart savedFoodCart = cartService.addNewFoodCart(customerId, foodCart);
		
		return new ResponseEntity<>(savedFoodCart,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/addItemToCart/{foodCartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemToCartHandler(@PathVariable Integer foodCartId,@PathVariable Integer itemId){
		
		FoodCart updatedCart = cartService.addItemToCart(foodCartId, itemId);
		
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/increaseItemQuantity/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantityOfItemHandler(@Valid @RequestBody FoodCart foodCart,@Valid @RequestBody Item item,@PathVariable("quantity") Integer quantity){
		
		FoodCart updateCart = cartService.increaseQuantityOfItem(foodCart, item, quantity);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PutMapping("/reduceItemQuantity/{quantity}")
	public ResponseEntity<FoodCart> reduceQuantityOfItemHandler(@Valid @RequestBody FoodCart foodCart,@Valid @RequestBody Item item,@PathVariable("quantity") Integer quantity){
		
		FoodCart updateCart = cartService.reduceQuantityOfItem(foodCart, item, quantity);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/removeItem/{foodCartId}")
	public ResponseEntity<FoodCart> removeItemFromCartHandler(@PathVariable Integer foodCartId,@Valid @RequestBody Item item){
		
		FoodCart updateCart = cartService.removeItemFromCart(foodCartId, item);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}




	@DeleteMapping(value = "/clearCart/{foodCartId}")
	public ResponseEntity<FoodCart> cleartCartHandler(@PathVariable Integer foodCartId){
		
		FoodCart emptyCart = cartService.clearCart(foodCartId);
		
		return new ResponseEntity<FoodCart>(emptyCart, HttpStatus.ACCEPTED);
		
	}




}

