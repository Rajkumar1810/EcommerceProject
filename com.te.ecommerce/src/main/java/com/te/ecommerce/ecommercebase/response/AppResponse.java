package com.te.ecommerce.ecommercebase.response;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AppResponse {
	private String token;
	private int status;
	private boolean error;
	private Object data;
	private String message;
	private Date timestamp;

}
