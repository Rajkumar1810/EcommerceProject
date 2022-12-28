package com.te.ecommerce.ecommercebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.ecommercebase.entity.CartItem;
@Repository
public interface CartItemRespository extends JpaRepository<CartItem, Integer> {

//	CartItem findOne(Double price);
	

}
