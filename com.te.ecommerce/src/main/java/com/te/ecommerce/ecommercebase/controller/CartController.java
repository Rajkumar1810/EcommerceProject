package com.te.ecommerce.ecommercebase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.ecommercebase.dto.CartItemDto;
import com.te.ecommerce.ecommercebase.dto.CartUpdateDto;
import com.te.ecommerce.ecommercebase.entity.Cart;
import com.te.ecommerce.ecommercebase.entity.CartItem;
import com.te.ecommerce.ecommercebase.response.AppResponse;
import com.te.ecommerce.ecommercebase.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private AppResponse appResponse;
	@Autowired
	private CartService cartService;

	@GetMapping("cartbill")
	public ResponseEntity<AppResponse> addCart(@RequestBody CartUpdateDto updateDto, CartItemDto cartItemDto,@PathVariable(value = "UserId") Integer  userId) {
		Cart cart = cartService.addCart(updateDto, cartItemDto,userId);
		if (cart != null) {
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Sucessfully add and Update to cart");
			appResponse.setData(cart);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSucessfully add to cart");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		}

	}
}