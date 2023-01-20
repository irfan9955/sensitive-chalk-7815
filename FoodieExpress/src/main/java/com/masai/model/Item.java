package com.masai.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Service
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	@Size(min = 3, max = 20)
	@NotBlank
	@NotEmpty
	@NotNull
	private String itemName;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@Min(1)
	private Integer quantity;
	
	@DecimalMin("20.00")
	private Double cost;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "items",fetch =  FetchType.EAGER)
	private List<Restaurant> resturants = new ArrayList<>();

	
}
