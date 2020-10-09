package com.example.SpringBatchRandomFIleWriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchRandomFIleWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchRandomFIleWriterApplication.class, args);
	}

}
