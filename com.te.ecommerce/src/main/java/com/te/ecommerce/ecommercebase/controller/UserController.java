package com.te.ecommerce.ecommercebase.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
import com.te.ecommerce.ecommercebase.response.AppResponse;
import com.te.ecommerce.ecommercebase.services.UserService;

@RestController
@RequestMapping(path = "user")
public class UserController {
	@Autowired
	private AppResponse appResponse;
	@Autowired
	private UserService userService;

	
	//	Register
	@PostMapping("/registration")
	public ResponseEntity<AppResponse> register(@ModelAttribute("user") RegisterDto registerDto) {
		User user = userService.save(registerDto);
		if (user != null) {
			appResponse.setError(false);
			appResponse.setMessage("register successfully");
			appResponse.setData(user);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
		
		

	}
	
	// Front end user object get 
	@ModelAttribute("user")
	private RegisterDto registerDto() {
		return new RegisterDto();
	}
	
	

	@PostMapping("/addAddress")
	public ResponseEntity<AppResponse> addAddBill(@RequestBody BillingAddressDto billingAddressDto) {
		BillingAddress address = userService.addAddBill(billingAddressDto);
		if (address != null) {
			appResponse.setError(false);
			appResponse.setMessage("register successfully");
			appResponse.setData(address);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/addshippingAdd")
	public ResponseEntity<AppResponse> addAddShippingBill(@RequestBody ShippingAddressDto shippingAddressDto) {
		ShippingAddress shippingAddress = userService.addAddShippingBill(shippingAddressDto);
		if (shippingAddress != null) {
			appResponse.setError(false);
			appResponse.setMessage("register successfully");
			appResponse.setData(shippingAddress);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@GetMapping("/get")
	public ResponseEntity<AppResponse> getAll() {
		List<Customer> customer = userService.getAll();
		if (customer != null) {
			appResponse.setError(false);
			appResponse.setMessage(" Successfully Got It");
			appResponse.setStatus(200);
			appResponse.setData(customer);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@GetMapping("/getbyId")
	public ResponseEntity<AppResponse> getAllDetails(@RequestBody SearchCusDto cusDto, DetailsCusDto detailsCusDto) {
		Customer customers = userService.getAllDetails(cusDto, detailsCusDto);
		if (customers != null) {
			appResponse.setError(false);
			appResponse.setMessage(" Successfully Got It");
			appResponse.setStatus(200);
			appResponse.setData(Arrays.asList(customers));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PostMapping("/billingaddressupdate")
	public ResponseEntity<AppResponse> updateBilling(BillingAddressDto addressDto) {
		BillingAddress billingAddress = userService.updateBilling(addressDto);
		if (billingAddress != null) {
			appResponse.setError(false);
			appResponse.setMessage(" Successfully Update");
			appResponse.setStatus(200);
			appResponse.setData(billingAddress);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/shippingaddressupdate")
	public ResponseEntity<AppResponse> updateShipping(ShippingAddressDto addressDto) {
		ShippingAddress shippingAddress = userService.updateShipping(addressDto);
		if (shippingAddress != null) {
			appResponse.setError(false);
			appResponse.setMessage(" Successfully Update");
			appResponse.setStatus(200);
			appResponse.setData(shippingAddress);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}
     @DeleteMapping("/billingdelete")
	public ResponseEntity<AppResponse>deleteaddress(DeleteAddressDto deleteAddressDto){
    	if (userService.deleteaddress(deleteAddressDto)) {
			appResponse.setError(false);
			appResponse.setMessage("Deleted Successfully ");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsuccessfully");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} 
     }
     @DeleteMapping("/shippingdelete")
 	public ResponseEntity<AppResponse>deleteShippingAddress(DeleteShippingAdd deleteAddressDto){
     	if (userService.deleteShippingAddress(deleteAddressDto)) {
 			appResponse.setError(false);
 			appResponse.setMessage("Deleted Successfully ");
 			appResponse.setStatus(200);
 			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

 		} else {
 			appResponse.setError(true);
 			appResponse.setMessage("Unsuccessfully");
 			appResponse.setStatus(400);
 			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
 		} 
      }
// 	Adding Billing Address of Customer
 	@PostMapping("/addBillingAddress/{Id}")
 	private ResponseEntity<AppResponse> billingAddress(@PathVariable Integer customerid,  @RequestBody BillingAddressDto addressDto) {
 		BillingAddressDto billingAddress = userService.billingAddress(addressDto, customerid);
 		if (billingAddress != null) {
 			appResponse.setError(false);
 			appResponse.setMessage("Sucessfully Added");
 			appResponse.setData(Arrays.asList(billingAddress));
 			appResponse.setStatus(200);
 			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
 		} else {
 			appResponse.setError(true);
 			appResponse.setMessage("Unsucessfull");
 			appResponse.setStatus(200);
 			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
 		}

 	}
}
