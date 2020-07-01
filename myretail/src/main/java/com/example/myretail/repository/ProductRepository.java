package com.example.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.myretail.domain.ProductPrice;

@Repository
public interface ProductRepository extends MongoRepository<ProductPrice, Long> {
 
	//ProductPrice findByProduct_id(String id);
}
