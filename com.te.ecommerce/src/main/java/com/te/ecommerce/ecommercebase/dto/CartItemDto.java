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

public class CartItemDto {
	private Integer cartItemId;
	private int quantity;
	private Double price ;
}
