package com.te.ecommerce.ecommercebase.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.ecommerce.ecommercebase.dto.CartItemDto;
import com.te.ecommerce.ecommercebase.dto.CartUpdateDto;
import com.te.ecommerce.ecommercebase.entity.Cart;
import com.te.ecommerce.ecommercebase.entity.CartItem;
import com.te.ecommerce.ecommercebase.entity.User;
import com.te.ecommerce.ecommercebase.exception.EcommerceExpection;
import com.te.ecommerce.ecommercebase.repository.CartItemRespository;
import com.te.ecommerce.ecommercebase.repository.CartRespository;
import com.te.ecommerce.ecommercebase.repository.ProductRespository;
import com.te.ecommerce.ecommercebase.repository.UserRespository;

@Service
public class CartSericeImpl implements CartService {
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private CartItemRespository cartItemRespository;
	@Autowired
	private CartRespository cartRespository;
	@Autowired
	private ProductRespository productRespository;

	@Override
	public Cart addCart(CartUpdateDto updateDto, CartItemDto cartItemDto, Integer userId) {
//		User user = userRespository.findById(userId).orElse(null);
//		if (user != null) {
		List<CartItem> cartItem = (List<CartItem>) cartItemRespository.findById(cartItemDto.getCartItemId())
				.orElse(null);
		BeanUtils.copyProperties(cartItemDto, cartItem);
		if (cartItem != null) {
			Cart cart = cartRespository.findById(updateDto.getCartId()).orElse(null);
			CartItem cartItem2 = cartItemRespository.findById(cartItemDto.getQuantity()).orElse(null);
//				CartItem item = cartItemRespository.findOne(cartItemDto.getPrice());
			cartItem2.setPrice(0.0);
			cartItem2.setQuantity(0);
			BeanUtils.copyProperties(cartItem2, cart);
			BeanUtils.copyProperties(cartItem2, cart);
			Cart cart2 = cartRespository.save(cart);
			cart2.setCartId(userId);
			Double price = 0.0;
			int quantity = 0;
			Double totalPrice = 0.0;
			for (int i = 0; i <= quantity; i++) {
				for (int j = 0; j < price; j++) {

					totalPrice = price * quantity;
					BeanUtils.copyProperties(totalPrice, cart2);

//						cartRespository.save(cart2);
				}

			}
			Cart cart3 = cartRespository.save(cart2);
			return cart3;

		}

		throw new EcommerceExpection("Cart is not Update");
	}

}
