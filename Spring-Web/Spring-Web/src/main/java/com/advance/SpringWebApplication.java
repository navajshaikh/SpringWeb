package com.advance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.advance.model1.Employee;
import com.advance.service1.EmployeeRepository;

@SpringBootApplication
public class SpringWebApplication extends SpringBootServletInitializer {

	
	@Autowired
	private EmployeeRepository repo;
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringWebApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner initDB() {
		return (args)->{
			repo.save(new Employee("Harry", 20000L));
			repo.save(new Employee("jack", 21000L));
			repo.save(new Employee("tony", 12010L));
		};
		
	}
	
	
	
	
	
}
