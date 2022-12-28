package com.te.ecommerce.ecommercebase.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authorities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer athoritiesId;
	@Email
	@NotEmpty
	private String email;
	
	private  String authority;
	
//	@OneToMany(mappedBy = "Product",fetch = FetchType.LAZY)
//	@JoinColumn(name = "product_Id")
//	private List<Product>products ; 
}
