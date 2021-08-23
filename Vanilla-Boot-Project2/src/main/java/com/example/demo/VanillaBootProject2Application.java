package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VanillaBootProject2Application {
	
//	@Bean
//	public FilterRegistrationBean CorsFilter() {
//		FilterRegistrationBean reg = new FilterRegistrationBean();
//		Filter cors = new CORSFilter();
//		reg.setFilter(cors);
//		return reg;
//	}

	public static void main(String[] args) {
		SpringApplication.run(VanillaBootProject2Application.class, args);
	}

}
