package com.te.ecommerce.ecommercebase.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.ecommerce.ecommercebase.dto.CartItemDto;
import com.te.ecommerce.ecommercebase.entity.CartItem;
import com.te.ecommerce.ecommercebase.entity.Product;
import com.te.ecommerce.ecommercebase.response.AppResponse;
import com.te.ecommerce.ecommercebase.services.CartItemService;

@RestController
@RequestMapping("/CartItem")
public class CartItemController {
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private AppResponse appResponse;
	//Add the Product
	@PostMapping("/addselectProduct")
	public ResponseEntity<AppResponse>addSelectPro(@RequestBody CartItem cartItem,Product product){
	CartItem item	=cartItemService.addselectPro(cartItem,product);
	if (item!=null) {
		appResponse.setError(false);
		appResponse.setStatus(200);
		appResponse.setMessage("Sucessfully add to cart");
		appResponse.setData(cartItem);
		return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);
		
	} else {
		appResponse.setError(true);
		appResponse.setStatus(400);
		appResponse.setMessage("UnSucessfully add to cart");
		return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);

	}
		
	}
	@GetMapping("/allcartitem")
	public ResponseEntity<AppResponse>getall(@RequestBody CartItemDto cartItemDto){
	List<CartItem > cartItems	=cartItemService.get(cartItemDto);
		if (cartItems !=null) {
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Sucessfully get all item");
			appResponse.setData(cartItems);
	        return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);
			
		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSucessfully ");
			return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);

		}
	}

	//Remove Single Product
	@DeleteMapping("/deletecartitem")
	public ResponseEntity<AppResponse>removeSelectPro(@RequestBody CartItemDto cartItemDto){
		
		if (cartItemService.removeSelectPro(cartItemDto)) {
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Sucessfully Remove cart");
	        return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);
			
		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSucessfully Remove cart");
			return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);

		}
	}

	
			
//	Remove All Product	
	@DeleteMapping("/deleteallcartitems")
	public ResponseEntity<AppResponse>removeallPro(CartItem cartItem){
	Boolean removeallPro = cartItemService.removeallPro(cartItem);
	if (removeallPro) {
		appResponse.setError(false);
		appResponse.setStatus(200);
		appResponse.setMessage("Sucessfully Remove all  to cart");
        return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);
		
	} else {
		appResponse.setError(true);
		appResponse.setStatus(400);
		appResponse.setMessage("UnSucessfully Remove all cart");
		return new ResponseEntity<AppResponse>(appResponse,HttpStatus.ACCEPTED);

	}
	}

}
