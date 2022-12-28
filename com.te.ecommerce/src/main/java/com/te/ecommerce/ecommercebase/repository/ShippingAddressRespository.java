package com.te.ecommerce.ecommercebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.ecommercebase.entity.ShippingAddress;
@Repository
public interface ShippingAddressRespository extends JpaRepository<ShippingAddress, Integer> {

}
