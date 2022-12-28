package com.te.ecommerce.ecommercebase.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@Column()
	private Double  totalPrice; 
     
//	@OneToOne(mappedBy = "cart")
//	private Customer customer;
//	@OneToOne(mappedBy = "cart")
//	private SalesOrder salesOrder;
	
	@OneToMany(mappedBy = "cart")
	private List<CartItem> cartItem;
}

