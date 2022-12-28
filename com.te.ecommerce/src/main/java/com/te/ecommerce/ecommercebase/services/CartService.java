package com.te.ecommerce.ecommercebase.services;

import org.springframework.stereotype.Service;

import com.te.ecommerce.ecommercebase.dto.CartItemDto;
import com.te.ecommerce.ecommercebase.dto.CartUpdateDto;
import com.te.ecommerce.ecommercebase.entity.Cart;
import com.te.ecommerce.ecommercebase.entity.CartItem;

@Service
public interface CartService {

	Cart addCart(CartUpdateDto updateDto, CartItemDto cartItemDto, Integer userId);

//	Cart addCart(CartUpdateDto updateDto, CartItem cartItem,UserId);

}
