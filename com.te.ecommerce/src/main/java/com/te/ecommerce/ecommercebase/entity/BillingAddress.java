package com.te.ecommerce.ecommercebase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  billingAddressId;
	@Column(length = 60)
	private String address;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 10)
	private Long  zipcode;
	@Column(length = 15)
	private String country;
	
//	@OneToOne (mappedBy ="billingAddress")
//	private Customer customer;
//	@OneToOne(mappedBy = "billingAddress")
//	private SalesOrder salesOrder;

}
