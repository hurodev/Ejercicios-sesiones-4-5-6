package com.example.Ejercicios.sesiones45.y6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"lenovo","legion",20000);
		Laptop laptop2 = new Laptop(null,"assus","strix",30000);


		repository.save(laptop1);
		repository.save(laptop2);

	}}
