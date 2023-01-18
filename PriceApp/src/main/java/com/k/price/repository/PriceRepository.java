package com.k.price.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.k.price.entity.Price;

public interface PriceRepository extends JpaRepository<Price, String> {

}
