package com.masai.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@ConstructorBinding
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Service
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	private String itemName;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	private Integer quantity;
	
	private Double cost;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "items",fetch =  FetchType.EAGER)
	private List<Restaurant> resturants = new ArrayList<>();

	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(category, cost, itemId, itemName, quantity, resturants);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(category, other.category) && Objects.equals(cost, other.cost)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(resturants, other.resturants);
	}

	
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<Restaurant> getResturants() {
		return resturants;
	}

	public void setResturants(List<Restaurant> resturants) {
		this.resturants = resturants;
	}

}
