package com.masai.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	public List<Item> findByItemName(String itemName);
	
	
	
}
