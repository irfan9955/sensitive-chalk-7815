package com.masai.service;

import java.util.List;

import com.masai.exception.RestaurantException;
import com.masai.model.Address;
import com.masai.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException;
	
	public Restaurant viewRestaurant(Integer resId) throws RestaurantException;
	
	public List<Restaurant> viewNearByRestaurant(Address address) throws RestaurantException;
	
	public List<Restaurant> viweRestaurantByItemName(String itemName) throws RestaurantException;
	
	

}
