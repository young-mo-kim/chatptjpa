package com.choon.chatptjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ChatPtJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatPtJpaApplication.class, args);
	}


		@Bean
	public WebMvcConfigurer crosConfigure() {

		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("Test==================");
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8080/", "http://localhost:8081/","http://localhost:3000/", "https://chunsik.shop","http://localhost:9000/", "http://localhost/", "ws://localhost")
						.allowedHeaders("*")
						.allowedMethods("*").allowCredentials(true).maxAge(3600);

			}
		};
	}
}
