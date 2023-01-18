package com.k.admin.service;

import java.util.List;

import com.k.admin.dto.ProductDto;
import com.k.admin.entity.Product;



public interface ProductService {
	
	
	
	public ProductDto addProduct(ProductDto product);
	
	public ProductDto updateProduct(String id,ProductDto productDto);
	
	
	Product getProductsById(String id);
	
	List<Product> getAllProducts();
	
	public void deleteProductById(String id);


	

}
