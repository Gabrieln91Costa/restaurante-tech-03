package br.com.restaurante.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(
	info = @Info(
		title = "Restaurante BackEnd",
		description = "API responsavel pela gestão da Restaurante",
		version="1"
	)
)
public class RestauranteApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

}
