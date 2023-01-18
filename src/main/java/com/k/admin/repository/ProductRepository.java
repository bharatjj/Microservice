package com.k.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.k.admin.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
