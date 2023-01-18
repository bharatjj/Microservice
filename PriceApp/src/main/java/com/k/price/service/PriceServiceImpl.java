package com.k.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k.price.dto.PriceDto;
import com.k.price.entity.Price;
import com.k.price.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceRepository priceRepository;

	@Override
	public Price addPriceWithProduct(PriceDto priceDto) {

		
		Price  price= new Price();
		price.setValue(priceDto.getValue());
		return priceRepository.save(price);
	}

	@Override
	public Price updateProductPrice(Price price) {

		return priceRepository.save(price);
	}

	@Override
	public void deletePrice(String priceId) {

		Price price = priceRepository.findById(priceId).get();

		priceRepository.delete(price);

	}

	@Override
	public Price getPriceById(String priceId) {

		Price price = priceRepository.findById(priceId).get();

		return price;

	}

}
