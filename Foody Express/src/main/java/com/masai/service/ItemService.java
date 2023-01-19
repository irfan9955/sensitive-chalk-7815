package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.ItemNotFoundException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;

@Service
public interface ItemService {

	public Item addItem(Item item) throws ItemNotFoundException;
	
	public Item updateItem(Item item) throws ItemNotFoundException;
	
	public Item viewItem (Item item) throws ItemNotFoundException;
	
	public Item removeItem(Item item) throws ItemNotFoundException;
	
	public List<Item> viewAllItemsByCategory(Category category) throws ItemNotFoundException;
	
	public List<Item> viewAllItemsOfRetaurant(Restaurant restaurant) throws ItemNotFoundException;
	
	public List<Item> viewAllItemsByName(String name) throws ItemNotFoundException;
 	
}
