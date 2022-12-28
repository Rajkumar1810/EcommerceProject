package com.te.ecommerce.ecommercebase.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.te.ecommerce.ecommercebase.dto.DeleteProductDto;
import com.te.ecommerce.ecommercebase.dto.ProductDto;
import com.te.ecommerce.ecommercebase.dto.SalesOrderDto;
import com.te.ecommerce.ecommercebase.dto.SearchProDto;
import com.te.ecommerce.ecommercebase.entity.Product;
import com.te.ecommerce.ecommercebase.entity.SalesOrder;

@Service
public interface AuthorityService {

	Product registerProduct(ProductDto productDto);

	Product updateProduct(ProductDto productDto);

	boolean deleteProduct(DeleteProductDto deleteProductDto);

	List<Product> getAll();

	Product searchProduct(SearchProDto proDto );

	List<SalesOrder> salesLists();

	SalesOrder getSale(SalesOrderDto salesOrderDto);

//	DetailsSalesDto salesLists();

	

}
