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

import com.masai.exception.ItemNotFoundException;
import com.masai.exception.RestaurantException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	
	@Autowired
	private ItemService itemService;
	
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Item> addItemHandler(@RequestBody Item item){
		
		Item savedItem = itemService.addItem(item);
		
		return new ResponseEntity<Item>(savedItem, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<Item> updateItemHandler(@RequestBody Item item){
		
		Item updatedItem = itemService.updateItem(item);
		
		return new ResponseEntity<Item>(updatedItem, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/view/{itemId}")
	public ResponseEntity<Item> viewItemHandler(@PathVariable Integer itemId){
		
		Item existedItem = itemService.viewItem(itemId);
		
		return new ResponseEntity<Item>(existedItem, HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/remove/{itemId}")
	public ResponseEntity<Item> removeItemHandler(@PathVariable Integer itemId){
		
		Item deletedItem = itemService.removeItem(itemId);
		
		return new ResponseEntity<Item>(deletedItem, HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/getByCategory")
	public ResponseEntity<List<Item>> viewAllItemsByCategoryHandler(@RequestBody Category category){
		
		List<Item> listItem = itemService.viewAllItemsByCategory(category);
		
		return new ResponseEntity<>(listItem, HttpStatus.ACCEPTED);
		
	}
	
	
	

	@PostMapping("/getByRestaurant")
	public ResponseEntity<List<Item>> viewAllItemsOfRestaurantHandler(@RequestBody Restaurant restaurant) throws ItemNotFoundException, RestaurantException{
		
		List<Item> listItem = itemService.viewAllItemsByRetaurant(restaurant);
		
		return new ResponseEntity<>(listItem, HttpStatus.ACCEPTED);
		
	}
	
	
	

	@PostMapping("/getByName/{name}")
	public ResponseEntity<List<Item>> viewAllItemsByNameHandler(@PathVariable("name") String itemName){
		
		List<Item> listItem = itemService.viewAllItemsByName(itemName);
		
		return new ResponseEntity<>(listItem, HttpStatus.ACCEPTED);
		
	}
	
	
	
	
}
