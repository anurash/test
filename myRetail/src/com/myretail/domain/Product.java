package com.myretail.domain;

public class Product {
	
	Long id;
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
	String name;
    ProductPrice current_price;
    

}
