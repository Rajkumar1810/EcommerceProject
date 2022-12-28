package com.te.ecommerce.ecommercebase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String category;
	private String description;
	private String manufacturer;
	private String name;
	private Double price;
	private Long unit;

//  @OneToOne(mappedBy = " product")
//  private CartItem cartItem;
}
