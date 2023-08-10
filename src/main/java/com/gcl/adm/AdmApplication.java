package com.gcl.adm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.gcl.dental.core")
@SpringBootApplication
public class AdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmApplication.class, args);
		
	}

}
