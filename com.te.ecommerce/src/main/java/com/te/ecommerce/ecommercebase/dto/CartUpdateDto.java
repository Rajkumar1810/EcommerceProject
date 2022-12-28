package com.te.ecommerce.ecommercebase.dto;

import javax.persistence.Column;

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
public class CartUpdateDto {
	
	private Integer cartId;
	private Double  totalPrice; 
	

}
