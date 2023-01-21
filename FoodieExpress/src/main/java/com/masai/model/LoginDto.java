package com.masai.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	
	private String mobileNo;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private LoginType loginType;
	
	

}
