package com.example.demo;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.Repository.AdminContactsRepository;
import com.example.demo.Repository.BookingRepository;
//import com.example.demo.Repository.CabInfoRepo;
//import com.example.demo.Repository.DriverInfoRepo;
import com.example.demo.Repository.DriverProfileRepository;
import com.example.demo.Repository.TripCabInfoRepository;
import com.example.demo.Tripdetails.AdminContacts;
//import com.example.demo.Repository.TripRepository;
import com.example.demo.Tripdetails.BookingRequest;
import com.example.demo.Tripdetails.Detailsonly;
import com.example.demo.Tripdetails.DriverProfile;
import com.example.demo.Tripdetails.TripCabInfo;
import com.example.demo.Tripdetails.Tripdetails;
//import com.example.demo.entity.TripCabInfo;
//import com.example.demo.repo.TripCabInfoRepository;
//import com.example.demo.repository.DriverProfileRepository;
//import com.example.demo.repo.CabInfoRepo;
//import com.example.demo.repo.DriverInfoRepo;
//import com.example.demo.model.CabInfo;
//import com.example.demo.model.DriverInfo;

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
		 @Autowired
		 AdminContactsRepository AdminContactsReposs;
		 @Autowired
			DriverProfileRepository  DriverProfileRepos;
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 @Override
	 public void run(String... args) throws Exception {
		 TripCabInfo tripdetails = new TripCabInfo(10001,"TN8S6677",10,"Bayline","Tambaram","Shollingnalur",LocalDate.now(),LocalTime.now(),10,2,8,LocalTime.of(10, 30),null,"Assigned",null,null,null,null,0);

	//---------------------------------------------------------------------------------------//		
		 AdminContacts contacts1 = new AdminContacts("+91- 123456789", "Ragahavan",true);
		 AdminContacts contacts2 = new AdminContacts("+91-(123)8492003", "santhosh",true);
		// AdminContactsReposs.save(contacts1);
		// AdminContactsReposs.save(contacts2);
	
		 //--------------------------------------------------------------------------//
		 DriverProfile profile = new DriverProfile("Jawahar","Driver","TN8S6677");
			//DriverProfileRepos.save(profile);
//		 DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//			Date date = df.parse("12-10-2025");
//			
			
		 
		 
			//jwt:
				// secret: secretkey123
	//BookingRequest book2=new BookingRequest(10022,10722,"gokul","alphacity","shollinganallur","velachery",LocalDateTime.now(),LocalTime.now(),0,10002,null,null,null,null,"assigned",null,null,null,null,0);
	//TripCabInfo tripdetails = new TripCabInfo(10001,"TN57 NS1000",10,"Bayline","Tambaram","Shollingnalur",LocalDate.now(),LocalDateTime.now(),10,2,8,LocalTime.of(10, 30),null,null,null,null,null,null,0);
  
		 //triprepo.save(tripdetails);
	 //repo.save(book2);
	
	 }
	 };
	
	
	
	
	
	
      }
}
