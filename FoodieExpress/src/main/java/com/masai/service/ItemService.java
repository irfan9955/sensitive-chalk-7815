package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.ItemNotFoundException;
import com.masai.exception.RestaurantException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;

public interface ItemService {

	public Item addItem(Item item) throws ItemNotFoundException;
	
	public Item updateItem(Item item) throws ItemNotFoundException;
	
	public Item viewItem (Integer itemId) throws ItemNotFoundException;
	
	public Item removeItem(Integer itemId) throws ItemNotFoundException;
	
	public List<Item> viewAllItemsByCategory(Category category) throws ItemNotFoundException;
	
	public List<Item> viewAllItemsByRetaurant(Restaurant restaurant) throws ItemNotFoundException,RestaurantException;
	
	public List<Item> viewAllItemsByName(String name) throws ItemNotFoundException;
 	
}
