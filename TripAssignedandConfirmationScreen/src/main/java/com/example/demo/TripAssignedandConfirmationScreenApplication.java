package com.example.demo;

import java.time.LocalDate;

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
import com.example.demo.Repository.TripCabInfoRepository;
//import com.example.demo.Repository.TripRepository;
import com.example.demo.Tripdetails.BookingRequest;
import com.example.demo.Tripdetails.Detailsonly;
import com.example.demo.Tripdetails.TripCabInfo;
import com.example.demo.Tripdetails.Tripdetails;
//import com.example.demo.entity.TripCabInfo;
//import com.example.demo.repo.TripCabInfoRepository;

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
		 @Autowired
			TripCabInfoRepository triprepo;
	 @Override
	 public void run(String... args) throws Exception {
	 

			
	
	
	BookingRequest book2=new BookingRequest(10022,10722,"gokul","alphacity","shollinganallur","velachery",LocalDateTime.now(),LocalTime.now(),0,10002,null,null,null,null,"assigned",null,null,null,null,0);
	//TripCabInfo tripdetails = new TripCabInfo(10001,"TN57 NS1000",10,"Bayline","Tambaram","Shollingnalur",LocalDate.now(),LocalDateTime.now(),10,2,8,LocalTime.of(10, 30),null,null,null,null,null,null,0);
  
	 
	 repo.save(book2);
	
	 }
	 };
	
	
	
	
	
	
      }
}
