package com.te.ecommerce.ecommercebase.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.ecommercebase.dto.CartItemDto;
import com.te.ecommerce.ecommercebase.entity.CartItem;
import com.te.ecommerce.ecommercebase.entity.Product;
import com.te.ecommerce.ecommercebase.exception.EcommerceExpection;
import com.te.ecommerce.ecommercebase.repository.CartItemRespository;
import com.te.ecommerce.ecommercebase.repository.ProductRespository;

@Service
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private CartItemRespository cartItemRespository;
	@Autowired
	private ProductRespository productRespository;

//Add to cart
	@Override
	public CartItem addselectPro(CartItem cartItem, Product product) {
		CartItem item = new CartItem();
//	    Product product1 = new Product();
		Product product2 = productRespository.findById(product.getProductId()).orElse(null);
		if (product.equals(product2)) {
			BeanUtils.copyProperties(product, item);
			return cartItemRespository.save(cartItem);
		}
		throw new EcommerceExpection("CartItem is not found");
	}

//	Remove particullar 
	@Override
	public Boolean removeSelectPro(CartItemDto cartItemDto) {
		CartItem item = cartItemRespository.findById(cartItemDto.getCartItemId()).orElse(null);
		if (item != null) {
			cartItemRespository.delete(item);
			return true;
		}
		throw new EcommerceExpection("Unsuccessful deleted ");
	}
	
// Remove All details
	@Override
	public Boolean removeallPro(CartItem cartItem) {
		List<CartItem> list = cartItemRespository.findAll();
		if (list != null) {
			cartItemRespository.deleteAll(list);
			return true;
		} else {
			throw new EcommerceExpection("Unsuccessful deleted ");
		}

	}

	@Override
	public List<CartItem> get(CartItemDto cartItemDto) {
		// TODO Get all the item
		
		return cartItemRespository.findAll();
	}

	
}
