package com.te.ecommerce.ecommercebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.ecommercebase.entity.BillingAddress;
@Repository
public interface BillingAddressRespository extends JpaRepository<BillingAddress, Integer> {

}
