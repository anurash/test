package com.example.myretail.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.myretail.domain.Product;
import com.example.myretail.domain.ProductPrice;
import com.example.myretail.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping(path="", produces = "application/json")
	public List<Product> fetchProducts() {

		return productService.getProducts();
	     
	}
	
	
	
	@RequestMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.findProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {
		 ProductPrice price = productService.updateProductDetails(product.getCurrent_price());
		 product.setCurrent_price(price);
		 return product;
	}

}