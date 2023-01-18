package com.k.admin.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
	
	private String priceId;
    @NotBlank(message = "Price cannot be blank")

	private BigDecimal value;
	
	private String productId;
	
	
	

}
