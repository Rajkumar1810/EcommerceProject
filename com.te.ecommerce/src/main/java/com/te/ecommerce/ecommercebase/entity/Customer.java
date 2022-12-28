package com.te.ecommerce.ecommercebase.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Customer {
	
	//Details collecting from the Customer 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerid;
	@Column(length = 30)
	private String firstName;
	@Column( length = 30)
	private String lastName;
	@Column(unique = true,length = 10)
	private Long customerPhone;
	
	// mapping 	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "foreign_shippingId", referencedColumnName = "shippingAddressId")
	private ShippingAddress shippingAddresses;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn( name="foreign_billingId", referencedColumnName = "billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn( name="foreign_userId",referencedColumnName = "userId")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "foreign_carId",referencedColumnName = "cartId")
	private Cart cart;

	@OneToOne(mappedBy = "customer")
	private SalesOrder salesOrder;
}
