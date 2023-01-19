package com.masai.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Service
public class FoodCart {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<>();	

}
