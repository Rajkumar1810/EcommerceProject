package com.te.ecommerce.ecommercebase.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.ecommerce.ecommercebase.dto.BillingAddressDto;
import com.te.ecommerce.ecommercebase.dto.DeleteAddressDto;
import com.te.ecommerce.ecommercebase.dto.DeleteShippingAdd;
import com.te.ecommerce.ecommercebase.dto.DetailsCusDto;
import com.te.ecommerce.ecommercebase.dto.LoginDto;
import com.te.ecommerce.ecommercebase.dto.RegisterDto;
import com.te.ecommerce.ecommercebase.dto.ShippingAddressDto;
import com.te.ecommerce.ecommercebase.dto.SearchCusDto;
import com.te.ecommerce.ecommercebase.entity.BillingAddress;
import com.te.ecommerce.ecommercebase.entity.Customer;
import com.te.ecommerce.ecommercebase.entity.Role;
import com.te.ecommerce.ecommercebase.entity.ShippingAddress;
import com.te.ecommerce.ecommercebase.entity.User;
import com.te.ecommerce.ecommercebase.exception.EcommerceExpection;
import com.te.ecommerce.ecommercebase.repository.BillingAddressRespository;
import com.te.ecommerce.ecommercebase.repository.CustomerRespository;
import com.te.ecommerce.ecommercebase.repository.RoleRespository;
import com.te.ecommerce.ecommercebase.repository.ShippingAddressRespository;
import com.te.ecommerce.ecommercebase.repository.UserRespository;

@Service
public class UserServiceImplemenration implements UserService {
	
	@Autowired
	private CustomerRespository customerRespository;
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private BillingAddressRespository billingAddressRespository;
	@Autowired
	private ShippingAddressRespository shippingAddressRespository;
	@Autowired
	private RoleRespository roleRespository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;

	//    Register new User
	@Override
	public User save(RegisterDto registerDto) {

		User user = new User();
		Customer customer = new Customer();
		customer.setFirstName(registerDto.getFirstName());
		customer.setLastName(registerDto.getLastName());
		customer.setCustomerPhone(registerDto.getCustomerPhone());
		
		customer.setUser(user);
		user.getRoles();
		user.setEmailId(registerDto.getEmailId());
		user.setPassword(registerDto.getPassword());
		passwordEncoder.encode(registerDto.getPassword());
		user.setUsername(registerDto.getUsername());
		Role role = new Role();
		role.setRoleName(registerDto.getRoleName());
		BeanUtils.copyProperties(registerDto, role);
		BeanUtils.copyProperties(registerDto, customer);
		BeanUtils.copyProperties(registerDto, user);
		customerRespository.save(customer);
		userRespository.save(user);
		roleRespository.save(role);
		return user;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user=userRespository.findByEmailId(username);
         if (user==null) {
        	 throw  new UsernameNotFoundException("Invalid username or password");
			
		}
//         basically User Object  belong to Spring Security , it is a Class 
         return new org.springframework.security.core.userdetails.User(user.getEmailId(),user.getPassword(), mapRoleAuthorities(user.getRoles()));
					
	}
	//get role Name
	private  Collection<? extends GrantedAuthority> mapRoleAuthorities(Collection<Role>roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
		 
	}


//  Register Billing Address
	@Override
	public BillingAddress addAddBill(BillingAddressDto billingAddressDto) {
		BillingAddress billingAddress = new BillingAddress();
		billingAddressDto.setAddress(billingAddressDto.getAddress());
		billingAddressDto.setCity(billingAddressDto.getCity());
		billingAddressDto.setCountry(billingAddressDto.getCountry());
		billingAddressDto.setState(billingAddressDto.getState());
		billingAddressDto.setZipcode(billingAddressDto.getZipcode());
//		Customer customer=customerRespository.findById(customerRespository.getById(null)
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		return billingAddressRespository.save(billingAddress);
	}

//	Registed Shipping Address
	@Override
	public ShippingAddress addAddShippingBill(ShippingAddressDto shippingAddressDto) {
		ShippingAddress shippingAddress = new ShippingAddress();
		shippingAddressDto.setAddress(shippingAddressDto.getAddress());
		shippingAddressDto.setCity(shippingAddressDto.getCity());
		shippingAddressDto.setCountry(shippingAddressDto.getCountry());
		shippingAddressDto.setState(shippingAddressDto.getState());
		shippingAddressDto.setZipcode(shippingAddressDto.getZipcode());
		BeanUtils.copyProperties(shippingAddressDto, shippingAddress);
		return shippingAddressRespository.save(shippingAddress);
	}

	@Override
	public Customer getAllDetails(SearchCusDto cusDto, DetailsCusDto detailsCusDto) {
		List<Customer> list = customerRespository.findAll();
		if (list != null) {
			Customer customer = customerRespository.findById(cusDto.getCustomerid()).orElse(null);
			BeanUtils.copyProperties(cusDto, customer);
			if (customer != null) {
				List<Customer> customernew = customerRespository.findAll();
				BeanUtils.copyProperties(customernew, customer);
			}
			return customerRespository.save(customer);

		}
		
		throw new EcommerceExpection("ID is not found ");
	}

	@Override
	public List<Customer> getAll() {
		return customerRespository.findAll();
	}

	@Override
	public BillingAddress updateBilling(BillingAddressDto addressDto) {
		BillingAddress billingAddress = billingAddressRespository.findById(addressDto.getBillingAddressId()).orElse(null);
		if (billingAddress!= null) {
			BeanUtils.copyProperties(addressDto, billingAddress);
			return billingAddressRespository.save(billingAddress);
		}
		throw new EcommerceExpection("ID is not found");
	}

	@Override
	public ShippingAddress updateShipping(ShippingAddressDto addressDto) {
//	Optional<ShippingAddress> shippingAddress	=shippingAddressRespository.findById((addressDto.getShippingAddressId());
	ShippingAddress shippingAddress	=shippingAddressRespository.findById(addressDto.getShippingAddressId()).orElse(null);
	if(shippingAddress!=null) {
		BeanUtils.copyProperties(addressDto, shippingAddress);
		
		return shippingAddressRespository.save(shippingAddress);
	}
		throw new EcommerceExpection("ID is not found");
	}

	@Override
	public boolean deleteaddress(DeleteAddressDto deleteAddressDto) {
		BillingAddress address=billingAddressRespository.findById(deleteAddressDto.getBillingAddressId()).orElse(null);
		if (address!=null) {
			billingAddressRespository.deleteById(deleteAddressDto.getBillingAddressId());
			return true;
		}
		throw new EcommerceExpection("Not deleted");
	}

	@Override
	public boolean deleteShippingAddress(DeleteShippingAdd deleteAddressDto) {
		ShippingAddress shippingAddress=shippingAddressRespository.findById(deleteAddressDto.getShippingAddressId()).orElse(null);
		if(shippingAddress !=null) {
			shippingAddressRespository.deleteById(deleteAddressDto.getShippingAddressId());
			return true;
		}
		throw new EcommerceExpection("Not deleted");
	}
	
//	Adding billing Address of customer
	@Override
	public BillingAddressDto billingAddress(BillingAddressDto addressDto, Integer customerid) {
		Customer customer = new Customer();
		customer.setCustomerid(customerid);
;
		Customer customerDet = customerRespository.findById(customer.getCustomerid()).orElse(null);

		if (customerDet != null) {
			
			BillingAddress billingAddress = new BillingAddress();
			
			BeanUtils.copyProperties(addressDto, billingAddress);
			
			BillingAddress savedBillingAddress = billingAddressRespository.save(billingAddress);
			
			if (savedBillingAddress!=null) {
				customerDet.setBillingAddress(savedBillingAddress);
				customerRespository.save(customerDet);
				return addressDto;
			}else {
//				return null;
				throw new EcommerceExpection("couldnt add the address");
			}
			
		} else {
//			return null;
			throw new EcommerceExpection("Customer Exception");
		}

	}

	

	
	
}
