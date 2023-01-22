package com.masai.service;


import com.masai.exception.CustomerNotFound;
import com.masai.exception.FoodCartException;
import com.masai.model.FoodCart;
import com.masai.model.Item;

public interface CartService {
	
	public FoodCart addNewFoodCart(Integer customerId , FoodCart foodCart) throws FoodCartException, CustomerNotFound;
	
	public FoodCart addItemToCart(Integer foodCartId, Integer itemId) throws FoodCartException;

	public FoodCart increaseQuantityOfItem(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException;
	
	public FoodCart reduceQuantityOfItem(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException;
	
	public FoodCart removeItemFromCart(FoodCart foodCart, Item item) throws FoodCartException;
	
	public FoodCart clearCart(Integer foodCartId) throws FoodCartException;
	
}
