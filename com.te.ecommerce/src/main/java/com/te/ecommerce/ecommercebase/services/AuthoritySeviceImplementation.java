package com.te.ecommerce.ecommercebase.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.ecommerce.ecommercebase.dto.DeleteProductDto;
import com.te.ecommerce.ecommercebase.dto.ProductDto;
import com.te.ecommerce.ecommercebase.dto.SalesOrderDto;
import com.te.ecommerce.ecommercebase.dto.SearchProDto;
import com.te.ecommerce.ecommercebase.entity.Product;
import com.te.ecommerce.ecommercebase.entity.SalesOrder;
import com.te.ecommerce.ecommercebase.exception.EcommerceExpection;
import com.te.ecommerce.ecommercebase.repository.AuthoritiesRespository;
import com.te.ecommerce.ecommercebase.repository.ProductRespository;
import com.te.ecommerce.ecommercebase.repository.SalesOrderRespository;

@Service
public class AuthoritySeviceImplementation implements AuthorityService {

	@Autowired
	private ProductRespository productRespository;
	@Autowired
	private AuthoritiesRespository authoritiesRespository;
	@Autowired
	private SalesOrderRespository salesOrderRespository;

//	New Product Add
	@Override
	public Product registerProduct(ProductDto productDto) {
		Product product = new Product();
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setManufacturer(productDto.getManufacturer());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setUnit(productDto.getUnit());
		BeanUtils.copyProperties(productDto, product);
		return productRespository.save(product);
	}

//	Update the Product
	@Override
	public Product updateProduct(ProductDto productDto) {
		Product product = productRespository.findById(productDto.getProductId()).orElse(null);
	
		if (product != null) {
			BeanUtils.copyProperties(productDto, product);
			return productRespository.save(product);
		}
	
		throw new EcommerceExpection("There is no productId");
	}

//	Delete the product
	@Override
	public boolean deleteProduct(DeleteProductDto deleteProductDto) {
		Product product = productRespository.findById(deleteProductDto.getProductId()).orElse(null);
		if (product != null) {
			productRespository.deleteById(deleteProductDto.getProductId());
			return true;
		}
		throw new EcommerceExpection("Id is not found");
	}

//	Get all  the Product list
	@Override
	public List<Product> getAll() {
		return productRespository.findAll();
	}

//	Get Particular Product
	@Override
	public Product searchProduct(SearchProDto proDto) {
		Product product = productRespository.findById(proDto.getProductId()).orElse(null);{
		
			return product;
		}
	}

	
//  Get all sales Item
	@Override
	public List<SalesOrder> salesLists() {
		return salesOrderRespository.findAll();
	}

//	Get details for particular Id
	@Override
	public SalesOrder getSale(SalesOrderDto salesOrderDto) {
		SalesOrder salesOrder = salesOrderRespository.findById(salesOrderDto.getSalesId()).orElse(null);
		if (salesOrder!=null) {
			BeanUtils.copyProperties(salesOrderDto, salesOrder);
			return salesOrder;
		}
		
		throw new EcommerceExpection("SaleId is not found");
	}

}
