package com.k.price.service;

import com.k.price.dto.PriceDto;
import com.k.price.entity.Price;



public interface PriceService {
	
	
	
	public Price addPriceWithProduct(PriceDto priceDto);
	
	public Price updateProductPrice(Price product);
	
	public void deletePrice(String priceId);
	
	
	public Price getPriceById(String priceId);

	

}
