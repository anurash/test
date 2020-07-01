package com.example.myretail.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProductPrice")
public class ProductPrice {

	@Id
	Long _id;
	
	String currency;
	Double price;
	
	public ProductPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductPrice(Long product_id, String currency, Double price) {
		//super();
		this._id = product_id;
		this.currency = currency;
		this.price = price;
	}

	public Long get_Id() {
		return this._id;
	}
	public void set_Id(Long product_id) {
		this._id = product_id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
}
