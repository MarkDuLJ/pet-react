package com.spring.petreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class PetReactApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(PetReactApplication.class, args);
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
	}

}
