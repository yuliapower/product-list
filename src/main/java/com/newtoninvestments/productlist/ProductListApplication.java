package com.newtoninvestments.productlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ProductListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductListApplication.class, args);
	}
}
