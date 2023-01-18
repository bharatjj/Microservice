package com.k.price.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Price {
	
	@Id
	private String priceId;
	
	private BigDecimal value;
	
	
	
	
	

}
