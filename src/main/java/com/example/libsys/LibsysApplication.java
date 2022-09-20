package com.example.libsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@RestController//added to make current class only a Controller (1)
public class LibsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibsysApplication.class, args);
	}

	//Added to make GET HTTP API for the Controller to hit (2)
	//(no service needed as all code in controller only)
	/*@GetMapping
	public List<String> getHello() {
		return List.of("Hello", "Clouding!!");
	}*/
}