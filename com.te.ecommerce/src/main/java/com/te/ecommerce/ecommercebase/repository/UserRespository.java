package com.te.ecommerce.ecommercebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.te.ecommerce.ecommercebase.entity.User;
//@EnableJpaRepositories
@Repository

public interface UserRespository extends JpaRepository<User, Integer> {
	 User findByEmailId(String emailId);
//	    Optional<User> findByUsernameOrEmail(String username, String email);
//	    Optional<User> findByUsername(String username);
//	    Boolean existsByUsername(String username);
//	    Boolean existsByEmail(String email);
}
