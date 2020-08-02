package com.diprobet.bookSharing;

import com.diprobet.bookSharing.filter.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BookSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSharingApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AuthenticationFilter());
		registration.addUrlPatterns("/*");
		registration.setName("authFilter");
		registration.setOrder(1);

		return registration;
	}
}
