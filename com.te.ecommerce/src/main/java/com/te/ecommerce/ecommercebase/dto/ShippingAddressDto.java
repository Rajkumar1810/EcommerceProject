package com.te.ecommerce.ecommercebase.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ShippingAddressDto {
	
	private Integer  shippingAddressId;
	private String address;
	private String city;
	private String state;
	private Long  zipcode;
	private String country;

}
