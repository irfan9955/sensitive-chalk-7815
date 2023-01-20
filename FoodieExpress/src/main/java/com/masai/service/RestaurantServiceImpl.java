package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.RestaurantException;
import com.masai.model.Address;
import com.masai.model.Restaurant;
import com.masai.repository.RestaurantDao;


@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDao resDao;
	
	@Override
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		// TODO Auto-generated method stub
		
		Restaurant rest = resDao.save(res);
		
		
		if(rest!=null) {
			return rest;
		}
		else
		throw new RestaurantException("Something went wrong......");
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException {
		// TODO Auto-generated method stub
		
		Optional<Restaurant> opt = resDao.findById(res.getRestaurantId());
		
		if(opt.isPresent()) {
			return resDao.save(res);
		}
		else
			throw new RestaurantException("Restaurant not found.....");
		
	}

	@Override
	public Restaurant viewRestaurant(Integer resId) throws RestaurantException {
		// TODO Auto-generated method stub
		Optional<Restaurant> opt = resDao.findById(resId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else
			throw new RestaurantException("Restaurant not found.....");
		
		
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(Address address) throws RestaurantException {
		// TODO Auto-generated method stub
		
		List<Restaurant> rests = resDao.findByAddress(address);
		
		
		if(rests.size()>0)
		return rests;
		else
			throw new RestaurantException("Restaurant not found with this address :"+address);
	}

	@Override
	public List<Restaurant> viweRestaurantByItemName(String itemName) throws RestaurantException {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	

}
