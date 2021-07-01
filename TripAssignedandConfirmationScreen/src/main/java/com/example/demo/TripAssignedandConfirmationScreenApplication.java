package com.example.demo;

import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.Repository.BookingRepository;
//import com.example.demo.Repository.TripRepository;
import com.example.demo.Tripdetails.BookingRequest;
import com.example.demo.Tripdetails.Detailsonly;
import com.example.demo.Tripdetails.Tripdetails;

@SpringBootApplication
public class TripAssignedandConfirmationScreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripAssignedandConfirmationScreenApplication.class, args);
	}
	 @Bean
	 public CommandLineRunner runner() {
	 return new CommandLineRunner() {
		 @Autowired
		 BookingRepository repo; 
	 @Override
	 public void run(String... args) throws Exception {
	 
		
	
	BookingRequest book1=new BookingRequest(110,1049,"abisekk","alphacity","shollinganallur","velachery",LocalDateTime.now(),LocalTime.now(),0,10002,null,null,null,null,null,null,null,null,null,0);
	 

	 
	 //repo.save(book1);
	 
	 
	
	 }
	 };
	
	
	
	
	
	
      }
}
