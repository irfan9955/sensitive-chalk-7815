package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ItemNotFoundException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private ItemRepository itemRepository;
	
	
	
	@Override
	public Item addItem(Item item) throws ItemNotFoundException {
		
		if(item==null) throw new ItemNotFoundException("Please add valid Item Details...");
		
		Item savedItem = itemRepository.save(item);
		
		return savedItem;
	}
	
	

	@Override
	public Item updateItem(Item item) throws ItemNotFoundException {
		
		Optional<Item> optional = itemRepository.findById(item.getItemId());

		if(optional.isPresent()) {
			
//			Item existedItem = optional.get();
			
			Item updatedItem = itemRepository.save(item);
			
			return updatedItem;
			
		}
		else {
			throw new ItemNotFoundException("There is no such item to be updated........Please add it first");
		}
	}

	
	
	@Override
	public Item viewItem(Item item) throws ItemNotFoundException {

		Optional<Item> optional = itemRepository.findById(item.getItemId());
		
		if(optional.isPresent()) {
			
			Item savedItem = optional.get();
			
			return savedItem;
			
		}
		else {
			throw new ItemNotFoundException("No such Item in List....");
		}
		
	}

	
	
	@Override
	public Item removeItem(Item item) throws ItemNotFoundException {
		
		Optional<Item> optional = itemRepository.findById(item.getItemId());
		
		if(optional.isPresent()) {
			
			Item existedItem = optional.get();
			
			itemRepository.delete(item);
			
			return existedItem;
		}
		else {
			throw new ItemNotFoundException("No Such Item to be Removed...... Please add it First");
		}
	}
	
	

	@Override
	public List<Item> viewAllItemsByCategory(Category category) throws ItemNotFoundException {
		
		List<Item> listByCategory = new ArrayList<>();
		
		List<Item> itemList = itemRepository.findAll();
		for(Item item : itemList) {
			
			if(item.getCategory().getCategoryName().equals(category.getCategoryName())){
				listByCategory.add(item);
			}
			
		}
		
		if(listByCategory.isEmpty()) throw new ItemNotFoundException("No such Item with this category name = "+category.getCategoryName()+" exist");

		return listByCategory;
	}

	
	
	@Override
	public List<Item> viewAllItemsOfRetaurant(Restaurant restaurant) throws ItemNotFoundException {
		
//		List<Item> itemList = restaurant.get
		
		return null;
	}


	
	@Override
	public List<Item> viewAllItemsByName(String name) throws ItemNotFoundException {
		
		List<Item> itemList = itemRepository.findByItemName(name);

		if(itemList.isEmpty()) throw new ItemNotFoundException("Item with this name not exist.....");
		
		return itemList;
	
	}
	

}
