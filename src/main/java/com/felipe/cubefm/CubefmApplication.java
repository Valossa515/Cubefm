package com.felipe.cubefm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.cubefm.services.S3Service;

@SpringBootApplication
public class CubefmApplication implements CommandLineRunner {
	@Autowired
	private S3Service s3Service;
	public static void main(String[] args) {
		SpringApplication.run(CubefmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\temp\\Minions.jpg");
	}
}
