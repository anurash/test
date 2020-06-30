package com.myretail.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myretail.domain.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

	@Autowired
	RestTemplate template ;
	
	
	
	@RequestMapping("/")
	public List<String> fetchProducts() {
		List<String> products = template.getForObject("http://redsky.target.com", List.class);
		return products;
	}
	
	
	@RequestMapping("/products/{id}")
	public Product getProductById(@RequestParam("id") Long id) {
		
		Product product = template.getForObject(""+"/"+id,Product.class);
		return product;
	}
	

}