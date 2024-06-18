package com.example.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =  SpringApplication.run(SpringDemoApplication.class, args);
	}

}
