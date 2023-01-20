package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.RestaurantException;
import com.masai.model.Address;
import com.masai.model.Restaurant;
import com.masai.service.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService resSer;
	
	@PostMapping("/restaurants")
	public ResponseEntity<Restaurant> addRestaurantHandler(@RequestBody Restaurant res) throws RestaurantException{
		
		Restaurant rest  = resSer.addRestaurant(res);
		
		
		return new ResponseEntity<Restaurant>(rest,HttpStatus.OK);
		
	}
	
	@PutMapping("/restaurants")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@RequestBody Restaurant res) throws RestaurantException{
		Restaurant rest = resSer.updateRestaurant(res);
		
        
		return new ResponseEntity<Restaurant>(rest,HttpStatus.OK);
		
		
		
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> viewRestaurantHandler(@PathVariable("id") Integer id) throws RestaurantException{
		
		Restaurant rest =  resSer.viewRestaurant(id);
		
		return new ResponseEntity<Restaurant>(rest,HttpStatus.OK);
		
	}
	
//	@GetMapping("/restaurant")
//	public ResponseEntity<List<Restaurant>> viewNearByRestaurantHandler(@PathVariable Address address) throws RestaurantException{
//		
//		List<Restaurant>  rest =resSer.viewNearByRestaurant(address);
//		
//		return new ResponseEntity<>(rest,HttpStatus.OK);
//		
//	}
//	
//	@GetMapping("/restaurant/{itemName}")
//	public ResponseEntity<List<Restaurant>> viweRestaurantByItemNameHandler(@PathVariable String itemName) throws RestaurantException{
//		
//		List<Restaurant> rest = resSer.viweRestaurantByItemName(itemName);
//		
//		return new ResponseEntity<>(rest,HttpStatus.OK);
//	}

	
	
}
