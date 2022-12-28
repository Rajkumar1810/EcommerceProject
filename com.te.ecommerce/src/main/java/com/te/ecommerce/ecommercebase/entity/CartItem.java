package com.te.ecommerce.ecommercebase.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartItemId;
	private int quantity;
	private Double price ;
	
	//Mapping
//	private Integer cartId;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "cartId", name = "foreign_cartId")
	private Cart  cart;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
}
