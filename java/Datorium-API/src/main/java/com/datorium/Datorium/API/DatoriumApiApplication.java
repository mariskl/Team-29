package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class DatoriumApiApplication { //Main class
	public static void main(String[] args) { //This is the only thing supposed to be here
		SpringApplication.run(DatoriumApiApplication.class, args);
	}
}