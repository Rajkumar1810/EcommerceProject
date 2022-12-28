package com.te.ecommerce.ecommercebase.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class SalesOrder {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salesId;
	private int countorder;

	//	Mapped

	
	@OneToOne (cascade = CascadeType.ALL)
//	@JoinColumn(name="forieng _cartId",referencedColumnName = "cartId")
	private Cart cart;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "customerId",name ="forieng_customerId" )
	private  Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "shippingAddressId",name ="forieng_shippingId" )
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "billingAddressId",name ="forieng_billingId" )
	private BillingAddress billingAddress;
	
	
}
