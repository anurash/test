package com.example.myretail.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.myretail.controller.ProductController;
import com.example.myretail.domain.Product;
import com.example.myretail.domain.ProductPrice;
import com.example.myretail.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@InjectMocks
    private ProductController mockController;
	
	@Mock
    private ProductService productService;
	
	 // private ProductRepository repo;
	  
//	   @Before
//	   public void setup() {
//		   MockitoAnnotations.initMocks(this);
//	   }
	    @Test
	    public void findProductById() {
	    	
	    	Product product = new Product((long) 13860428,"The Big Lebowski (Blu-ray) (Widescreen)");
	    	
	    	ProductPrice price = new ProductPrice();
	    	price.setCurrency("USD");
	    	price.setPrice(13.49);
	    	price.set_Id((long)13860428);
	    	product.setCurrent_price(price);
	  
	    	try {
				given(mockController.getProductById((long) 13860428).getBody()).willReturn((product));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
	    	
	    	Product expected = null;
			try {
				expected = productService.findProductById((long) 13860428);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	assertThat(expected).isNotNull();
	    	
	    	
	       }
	    
	    @Test
 public void updateProductDetails() {
	    	
	    	Product product = new Product((long) 13860428,"The Big Lebowski (Blu-ray) (Widescreen)");
	    	
	    	ProductPrice price = new ProductPrice();
	    	price.setCurrency("USD");
	    	price.setPrice(15.00);
	    	price.set_Id((long)13860428);
	    	product.setCurrent_price(price);
	  
	    	try {
				given(mockController.updateProduct((long)13860428, product).getBody()).willReturn(product);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
//	    	ProductPrice expected = null;
//			try {
//				expected = productService.updateProductDetails(price);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    	assertThat(expected).isNotNull();
	    	
	    	
	       }
	    
	    
}
