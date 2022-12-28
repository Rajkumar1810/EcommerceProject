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
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  shippingAddressId;
	private String address;
	private String city;
	private String state;
	private Long  zipcode;
	private String country;
	
//	@OneToOne(mappedBy ="shippingAddresses" )
//	private Customer customer;
//   @OneToOne(mappedBy = " billingAddress")
//	private SalesOrder salesOrder;
}
