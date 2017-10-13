package com.acnovate.hexm.ppm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.acnovate.hexm.ppm")
public class HexmPpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexmPpmApplication.class, args);
	}
}
