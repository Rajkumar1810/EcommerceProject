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
public class ProductDto {
	  
	  private Integer productId;
	  private String category;
	  private String description;
	  private String manufacturer;
	  private String name;
	  private Double price;
	  private Long unit;

}
