package com.k.admin.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
	
	
	
    private String pid;
	
    
    @NotBlank(message = "Product name cannot be blank")
	private String name;
	
    @NotBlank(message = "Product description cannot be blank")
	private String description;
	
	private BigDecimal  value;
	
	private String priceId;
	
	
	
	

}
