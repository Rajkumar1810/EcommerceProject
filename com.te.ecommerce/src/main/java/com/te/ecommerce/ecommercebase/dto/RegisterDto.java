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
public class RegisterDto {
	
	
	private String firstName;
	private String lastName;
	private String username;
	private String  emailId;
	private String  password;
//	private boolean enabled;
	private Long customerPhone;
	private String roleName;
	

}
