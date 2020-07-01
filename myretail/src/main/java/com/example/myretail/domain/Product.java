package com.example.myretail.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Product {
	
	Long id;
	String name;
	@JsonInclude(Include.NON_NULL)
	   ProductPrice current_price;
	public Product(Long id, String string) {
		this.id = id;
		this.name = string;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductPrice getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(ProductPrice current_price) {
		this.current_price = current_price;
	}

    

}
