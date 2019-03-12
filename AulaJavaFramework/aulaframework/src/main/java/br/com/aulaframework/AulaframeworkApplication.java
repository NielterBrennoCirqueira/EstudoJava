package br.com.aulaframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class AulaframeworkApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AulaframeworkApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaframeworkApplication.class, args);
	}

}
