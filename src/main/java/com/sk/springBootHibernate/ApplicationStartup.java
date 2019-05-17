package com.sk.springBootHibernate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.sk.springBootHibernate.*")
public class ApplicationStartup {
	
	
	public static void main(String args[]){
		
		SpringApplication.run(ApplicationStartup.class);
		
	}
	
	
	

}
