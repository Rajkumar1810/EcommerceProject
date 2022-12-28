package com.te.ecommerce.ecommercebase.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetailsCusDto {
	
	private String firstName;
	private String lastName;
	private String  emailId;
	private String  password;
//	private boolean enabled;
//	private String address;
	private String city;
	private String state;
	private Long  zipcode;
	private String country;

}
