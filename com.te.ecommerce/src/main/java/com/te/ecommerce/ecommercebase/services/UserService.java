package com.te.ecommerce.ecommercebase.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.te.ecommerce.ecommercebase.dto.BillingAddressDto;
import com.te.ecommerce.ecommercebase.dto.DeleteAddressDto;
import com.te.ecommerce.ecommercebase.dto.DeleteShippingAdd;
import com.te.ecommerce.ecommercebase.dto.DetailsCusDto;
import com.te.ecommerce.ecommercebase.dto.RegisterDto;
import com.te.ecommerce.ecommercebase.dto.ShippingAddressDto;
import com.te.ecommerce.ecommercebase.dto.SearchCusDto;
import com.te.ecommerce.ecommercebase.entity.BillingAddress;
import com.te.ecommerce.ecommercebase.entity.Customer;
import com.te.ecommerce.ecommercebase.entity.ShippingAddress;
import com.te.ecommerce.ecommercebase.entity.User;

public interface UserService extends UserDetailsService {

	User save(RegisterDto registerDto);
	
//	User login(LoginDto loginDto);
 
	BillingAddress addAddBill(BillingAddressDto billingAddressDto);

	ShippingAddress addAddShippingBill(ShippingAddressDto shippingAddressDto);

	Customer getAllDetails(SearchCusDto cusDto, DetailsCusDto detailsCusDto);

	List<Customer> getAll();

	BillingAddress updateBilling(BillingAddressDto addressDto);

	ShippingAddress updateShipping(ShippingAddressDto addressDto);

	boolean deleteaddress(DeleteAddressDto deleteAddressDto);

	boolean deleteShippingAddress(DeleteShippingAdd deleteAddressDto);

	BillingAddressDto billingAddress(BillingAddressDto addressDto, Integer customerid);

	

	 

//	Customer getAllDetails(cus);

	


	
}
