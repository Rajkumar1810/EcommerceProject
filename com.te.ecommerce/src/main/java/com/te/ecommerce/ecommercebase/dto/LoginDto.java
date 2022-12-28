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
public class LoginDto {
	

	private String  username;
	private String emailId;
	private String  password;

}
