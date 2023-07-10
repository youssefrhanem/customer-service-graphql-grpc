package com.rhanem.customerservice;

import com.rhanem.customerservice.entities.Customer;
import com.rhanem.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
					.name("youssef")
					.email("youssefrhanem@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("mohammed")
					.email("mohammed@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("sara")
					.email("sara@gmail.com")
					.build());
		};
	}

}
