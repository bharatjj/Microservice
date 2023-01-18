package com.k.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k.price.dto.PriceDto;
import com.k.price.entity.Price;
import com.k.price.service.PriceService;

@RestController
@RequestMapping("/price")
@CrossOrigin(origins = "*")
public class PriceController {
	
	
	
	@Autowired
	PriceService  priceService;
	
	
	
//	@RequestMapping("/getAllPrice")
//	public List<Price> getProducts()
//	{
//		//return priceService.getAllPrice();
//		
//	}
	

	
	@PostMapping("/addPrice")

	public Price savePrice(@RequestBody  PriceDto priceDto)
	{
		
		return priceService.addPriceWithProduct(priceDto);
		
	}
	

	
	@PutMapping("/updateProduct")

	public Price updatePrice(@RequestBody  Price price)
	{
		
		return priceService.updateProductPrice(price);

	}
	

	@DeleteMapping("/deleteProduct/{id}")

	public String deletePriceById( @PathVariable String id)
	{
		
		priceService.deletePrice(id);
		 
		 return "Price with id" +id +"is deleted";
				 

		
	}
	
	
	@RequestMapping("/getPrice/{id}")

	public Price getProductById( @PathVariable String id)
	{
		
		 Price price=priceService.getPriceById(id);
		 
		 return price;
				 

		
	}
	
	
	
	

}
