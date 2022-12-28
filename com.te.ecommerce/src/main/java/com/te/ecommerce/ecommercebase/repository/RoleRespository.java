package com.te.ecommerce.ecommercebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.ecommerce.ecommercebase.entity.Role;

public interface RoleRespository extends JpaRepository<Role, Integer> {
	

}
