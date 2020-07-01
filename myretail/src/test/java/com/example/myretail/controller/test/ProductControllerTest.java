package com.example.myretail.controller.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.myretail.controller.ProductController;
import com.example.myretail.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
 
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private ProductService service;
    //@Autowired MongoTemplate mongoTemplate;
    
    @Test
    public void fetchProducts() throws Exception {
    	
    	//assertThat(service.getProducts().contains(null));
    	
    	 mvc.perform(get("/products")
    		      .contentType(MediaType.APPLICATION_JSON))
    	 .andDo(print())
    		      .andExpect(status().isOk());
    		      //.andExpect(content().string(containsString("The Big Lebowski (Blu-ray) (Widescreen)")));
    }
 
    @Test
    public void getProductById() throws Exception {
    	
    	//assertThat(service.getProducts().contains(null));
    	
    	 mvc.perform(get("/products/13860428")
    		      .contentType(MediaType.APPLICATION_JSON))
    	 .andDo(print())
    		      .andExpect(status().isOk())
    		      .andExpect(content().string(containsString("13860428")));
    }
    
    
    
    // write test cases here
}