package com.myretail.product.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.domain.ProductPrice;

public interface ProductMongoRepository extends MongoRepository<ProductPrice, Long> {

 public ProductPrice findByproductId(Long productId);
  
}