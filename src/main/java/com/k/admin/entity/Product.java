package com.k.admin.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {
	
	@Id
	private String pid;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private String priceId;

	
	
	
	
	

}
