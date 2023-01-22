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

import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.service.CartService;

@RestController("/cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/addItemToCart")
	public ResponseEntity<FoodCart> addItemToCartHandler(@RequestBody FoodCart foodCart, @RequestBody Item item){
		
		FoodCart updatedCart = cartService.addItemToCart(foodCart, item);
		
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
	
	
	
	@DeleteMapping("/removeItem")
	public ResponseEntity<FoodCart> removeItemFromCartHandler(@Valid @RequestBody FoodCart foodCart,@Valid @RequestBody Item item){
		
		FoodCart updateCart = cartService.removeItemFromCart(foodCart, item);
		
		return new ResponseEntity<FoodCart>(updateCart, HttpStatus.ACCEPTED);
		
	}




	@PutMapping(value = "/clearCart")
	public ResponseEntity<FoodCart> cleartCartHandler(@Valid @RequestBody FoodCart foodCart){
		
		FoodCart emptyCart = cartService.clearCart(foodCart);
		
		return new ResponseEntity<FoodCart>(emptyCart, HttpStatus.ACCEPTED);
		
	}




}

