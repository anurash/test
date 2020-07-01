package com.example.myretail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myretail.domain.Product;
import com.example.myretail.domain.ProductPrice;
import com.example.myretail.repository.ProductRepository;

@Service

public class ProductService {
	@Autowired
	ProductRepository productRepo;

	public List<Product> getProducts() {

		  List<Product> products = new ArrayList<Product>();
	      products.add(new Product(new Long(54456119),"Creamy Peanut Butter 40oz - Good &#38; Gather&#8482;"));
	      products.add(new Product(new Long(13860428),"The Big Lebowski (Blu-ray) (Widescreen)\r\n" + 
	      		""));
	      products.add(new Product(new Long(13264003),"Jif Natural Creamy Peanut Butter - 40oz"));
	      products.add(new Product(new Long(12954218),"Kraft Macaroni &#38; Cheese Dinner Original - 7.25oz"));
	      
	      return products;
	}
	
	public Product findProductById(Long id) {
		Product product = null;
		List<Product> products = getProducts();
		for(Product prod:products) {
			if(prod.getId().longValue() == id.longValue()) {
				product=prod;
				break;
			}
		}
		if(product == null) {
			System.out.println("Product Not Found!!");
			return null;
			
		}
		Optional<ProductPrice> price =  productRepo.findById(id);
		product.setCurrent_price(price.get());
		return product;
		
	}
	
	public ProductPrice updateProductDetails(ProductPrice price) {
		return productRepo.save(price);
	}
	
	
	
}
