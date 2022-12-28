package com.te.ecommerce.ecommercebase.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.ecommerce.ecommercebase.dto.DeleteProductDto;
import com.te.ecommerce.ecommercebase.dto.ProductDto;
import com.te.ecommerce.ecommercebase.dto.SalesOrderDto;
import com.te.ecommerce.ecommercebase.dto.SearchProDto;
import com.te.ecommerce.ecommercebase.entity.Product;
import com.te.ecommerce.ecommercebase.entity.SalesOrder;
import com.te.ecommerce.ecommercebase.response.AppResponse;
import com.te.ecommerce.ecommercebase.services.AuthorityService;

@RestController
@RequestMapping(path = "Author")
public class AuthoritiesController {
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private AppResponse appResponse;

//	New Product Register
	@PostMapping("/productReg")
	public ResponseEntity<AppResponse> registerProduct(@RequestBody ProductDto productDto) {
		Product product = authorityService.registerProduct(productDto);
		if (product != null) {
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully added Product");
			appResponse.setData(product);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully added Product");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);
		}

	}

//	Modify the product
	@PutMapping("/updataproduct")
	public ResponseEntity<AppResponse> updateProduct(@RequestBody ProductDto productDto) {
		Product product = authorityService.updateProduct(productDto);
		if (product != null) {
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully update ");
			appResponse.setData(product);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully Update");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);
		}
	}

//	Delete the Product
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<AppResponse> deleteProduct(@RequestBody DeleteProductDto deleteProductDto) {

		if (authorityService.deleteProduct(deleteProductDto)) {
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully delete ");

			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully delete");
//			appResponse.setData(product);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);
		}
	}

//	Get all the  Product
	@GetMapping("/getproduct")
	public ResponseEntity<AppResponse> getAll() {
		List<Product> products = authorityService.getAll();
		if (products != null) {
			appResponse.setData(Arrays.asList(products));
			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully Got ");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully ");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);
		}

	}

	// Particular product search
	@GetMapping("/searchproduct")
	public ResponseEntity<AppResponse> searchProduct(@RequestBody SearchProDto proDto) {
		Product product2 = authorityService.searchProduct(proDto);
		if (product2 != null) {

			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully Get Produt details ");
			appResponse.setData(product2);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully ");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);

		}
	}

//	Get Particular Sales list
	@GetMapping("/saleslist")
	public ResponseEntity<AppResponse> salesLists() {
		List<SalesOrder> orders = authorityService.salesLists();
		if (orders!= null) {

			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully Get all details ");
//			appResponse.setData(p);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully ");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);

		}
		}
	
	@GetMapping("/saleid")
	public ResponseEntity<AppResponse>getSale(@RequestBody SalesOrderDto salesOrderDto){
	  SalesOrder order =  authorityService.getSale(salesOrderDto);
		if (order!= null) {

			appResponse.setError(false);
			appResponse.setStatus(200);
			appResponse.setMessage("Successfully Get  details ");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		} else {
			appResponse.setError(true);
			appResponse.setStatus(400);
			appResponse.setMessage("UnSuccessfully ");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_ACCEPTABLE);

		}
	}
	

}
