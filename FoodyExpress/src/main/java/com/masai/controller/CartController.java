package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	
	@PutMapping(value = "/addItemToCart")
	public ResponseEntity<FoodCart> addItemToCartHandler(@RequestBody FoodCart foodCart, @RequestBody Item item){
		
		FoodCart updatedCart = cartService.addItemToCart(foodCart, item);
		
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping(value = "/increaseItemQuantity")
	public ResponseEntity<FoodCart> increaseQuantityOfItemHandler(@RequestBody FoodCart foodCart, @RequestBody Item item, Integer quantity){
		
		FoodCart updateCart = cartService.increaseQuantityOfItem(foodCart, item, quantity);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PutMapping(value = "/reduceItemQuantity")
	public ResponseEntity<FoodCart> reduceQuantityOfItemHandler(@RequestBody FoodCart foodCart, @RequestBody Item item, Integer quantity){
		
		FoodCart updateCart = cartService.reduceQuantityOfItem(foodCart, item, quantity);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PutMapping(value = "/removeItem")
	public ResponseEntity<FoodCart> removeItemFromCartHandler(@RequestBody FoodCart foodCart, @RequestBody Item item){
		
		FoodCart updateCart = cartService.removeItemFromCart(foodCart, item);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}




	@PutMapping(value = "/clearCart")
	public ResponseEntity<FoodCart> cleartCartHandler(@RequestBody FoodCart foodCart){
		
		FoodCart emptyCart = cartService.clearCart(foodCart);
		
		return new ResponseEntity<FoodCart>(emptyCart, HttpStatus.ACCEPTED);
		
	}




}

