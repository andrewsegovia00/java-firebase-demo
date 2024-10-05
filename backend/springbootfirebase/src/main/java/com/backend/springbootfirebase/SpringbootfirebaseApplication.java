package com.backend.springbootfirebase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootfirebaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootfirebaseApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")  // Allow all paths
						.allowedOrigins("http://localhost:3000")  // Allow this origin (React app)
						.allowedMethods("GET", "POST", "DELETE", "PATCH")  // Allow specific HTTP methods
						.allowedHeaders("*");  // Allow all headers
			}
		};
	}
}
