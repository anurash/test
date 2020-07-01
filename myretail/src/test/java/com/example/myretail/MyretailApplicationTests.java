package com.example.myretail;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myretail.controller.ProductController;

@SpringBootTest
class MyretailApplicationTests {
	
	@Autowired
	private ProductController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
