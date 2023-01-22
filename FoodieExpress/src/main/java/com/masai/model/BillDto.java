package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
	
	private String customerName;
	
	private LocalDateTime localdatetime;
	
	private List<Item>  items;
	
	private Double totalCost;
	
	

}
