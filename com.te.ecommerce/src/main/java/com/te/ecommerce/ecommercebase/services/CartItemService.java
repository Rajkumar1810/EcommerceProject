package com.te.ecommerce.ecommercebase.services;




import java.util.List;

import com.te.ecommerce.ecommercebase.dto.CartItemDto;
import com.te.ecommerce.ecommercebase.entity.CartItem;
import com.te.ecommerce.ecommercebase.entity.Product;


public interface CartItemService {

	CartItem addselectPro(CartItem cartItem,Product product);

	Boolean removeSelectPro(CartItemDto cartItemDto);

	Boolean removeallPro(CartItem cartItem);

	List<CartItem> get(CartItemDto cartItemDto);

	

	

}
