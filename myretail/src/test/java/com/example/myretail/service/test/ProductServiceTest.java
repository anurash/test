package com.example.myretail.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.myretail.domain.Product;
import com.example.myretail.domain.ProductPrice;
import com.example.myretail.repository.ProductRepository;
import com.example.myretail.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
    private ProductService mockService;
	
	@Mock
    private ProductRepository mockRepository;
	
	 // private ProductRepository repo;
	  
//	   @Before
//	   public void setup() {
//		   MockitoAnnotations.initMocks(this);
//	   }
	    @Test
	    public void findProductById() {
	    	
	    	//Product product = new Product((long) 13860428,"The Big Lebowski (Blu-ray) (Widescreen)");
	    	
	    	ProductPrice price = new ProductPrice();
	    	price.setCurrency("USD");
	    	price.setPrice(13.49);
	    	price.set_Id((long)13860428);
	  
	    	given(mockRepository.findById((long) 13860428)).willReturn(Optional.of(price));
	    	
	    	final Product expected = mockService.findProductById((long) 13860428);
	    	assertThat(expected).isNotNull();
	    	
	    	
	       }
	    
	    @Test
 public void updateProductDetails() {
	    	
	    	//Product product = new Product((long) 13860428,"The Big Lebowski (Blu-ray) (Widescreen)");
	    	
	    	ProductPrice price = new ProductPrice();
	    	price.setCurrency("USD");
	    	price.setPrice(15.00);
	    	price.set_Id((long)13860428);
	  
	    	given(mockRepository.save(price)).willReturn(price);
	    	
	    	final ProductPrice expected = mockService.updateProductDetails(price);
	    	assertThat(expected).isNotNull();
	    	
	    	
	       }
	    
	    
}
