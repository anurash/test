package com.example.myretail.controller;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.myretail.domain.Product;
import com.example.myretail.domain.ProductPrice;
import com.example.myretail.service.ProductService;

@RestController
@EnableRetry
@RequestMapping("/products")
public class ProductController {
	
    Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping(path="", produces = "application/json")
	public ResponseEntity<List<Product>> fetchProducts() throws Exception {
        logger.info("Fetching Products .....");
		return new ResponseEntity<List<Product>>(productService.getProducts(),HttpStatus.OK);
	     
	}
	
	
	
	@RequestMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {
		logger.info("Fetching Product with ID "+id.longValue());
		return new ResponseEntity<Product>(productService.findProductById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	 @Retryable(
		      value = { SQLException.class }, 
		      maxAttempts = 2,
		      backoff = @Backoff(delay = 5000))
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product product) throws Exception {
		logger.info("Updating Product with ID "+id.longValue());
		 ProductPrice price = productService.updateProductDetails(product.getCurrent_price());
		 product.setCurrent_price(price);
		 return new ResponseEntity<Product>(product,HttpStatus.OK);
	}

}