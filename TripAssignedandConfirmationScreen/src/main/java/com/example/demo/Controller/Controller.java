package com.example.demo.Controller;
import java.time.LocalTime;


import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

//import java.util.NoSuchElementException;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.AdminContactsRepository;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.DriverNotificationRepository;
import com.example.demo.Repository.DriverProfileRepository;
import com.example.demo.Tripdetails.AdminContacts;
import com.example.demo.Tripdetails.BookingRequest;
import com.example.demo.Tripdetails.DriverProfile;
import com.example.demo.Tripdetails.TripAssignedDetails;
import com.example.demo.Tripdetails.TripCabInfo;
//import com.example.demo.Repository.TripRepository;
import com.example.demo.Tripdetails.Tripdetails;

//import com.example.demo.repository.DriverNotificationRepository;
//import com.example.demo.entity.TripCabInfo;
import com.example.demo.service.TripService;

@RestController
public class Controller {

	@Autowired
	TripService service;
	@Autowired
	private BookingRepository repo;
	
	@Autowired
	private DriverNotificationRepository repofordrivernotification;
	
	@Autowired
	private DriverProfileRepository repos;
	
	@Autowired
	private AdminContactsRepository reposs;
	//ArrayList n=new ArrayList();
//	List<Students> student=Arrays.asList();
	
     public BookingRepository getRepo() {
		return repo;
	}
     @Autowired
	public void setRepo(BookingRepository repo) {
		this.repo = repo;
	}
	@GetMapping(path="/All")
public List<BookingRequest> getallplans(){
	
	return this.repo.findAll();
	
}
       @GetMapping(path="/Getalldetails/{TripId}")                           
public List<BookingRequest> getbytripid(@PathVariable("TripId") long srchid){
    	   Optional<List<BookingRequest>> book=this.service.findByTripCabId(srchid);
    	   
		return book.get();
    	   
       }

       @GetMapping(path="/Address/")                           
       public List<BookingRequest> getbytripid1(@RequestParam(value 	= "TripId") long srchid){
           	   Optional<List<BookingRequest>> book=this.service.findByTripCabId(srchid);
           	  
       		return book.get();
           	   
              }



     @PutMapping("/update/{employeeId}")
     public ResponseEntity<BookingRequest> updatebyid(@PathVariable("employeeId")Long id ,@RequestBody BookingRequest entryset){
     Optional<BookingRequest> entity=repo.findById(id);
     System.out.print(entity.get());
     	BookingRequest bookingrequest=null;
     	if(entity.isPresent()) {
 System.out.print("hi");
     		bookingrequest=entity.get();
     			bookingrequest.setStatus(entryset.getStatus());

     		this.repo.save(bookingrequest);
     	}
     		return ResponseEntity.status(HttpStatus.OK).body(bookingrequest);
     		}
    
     
     @PutMapping("/update/for/{TripId}")
     public ResponseEntity<BookingRequest> updatebytripid(@PathVariable("TripId")Long id,@RequestBody List<BookingRequest> entryset){
    	 System.out.println(entryset);
      		 
    	BookingRequest entryset1= service.updatebytripid(id,entryset); 
      	 
    	return ResponseEntity.status(HttpStatus.OK).body(entryset1);
       }
        
@GetMapping(path = "/bookings/status/{TripId}")
public ResponseEntity<List<BookingRequest>> getFilteredBookings(@PathVariable("TripId") long tripId)
{
	//System.out.println(tripId);
	List<BookingRequest> requests = this.service.findShowusers(tripId).get();
	
	return ResponseEntity.status(HttpStatus.OK).body(requests);
}

@PutMapping("/update/for/show/{TripId}")
public ResponseEntity<BookingRequest> updatebytripidforshow(@PathVariable("TripId")Long id ,@RequestBody List<BookingRequest> entryset){
	 System.out.print(entryset);
	
	BookingRequest entryset1= service.updatebytripidforshow(id,entryset); 
 	 
	return ResponseEntity.status(HttpStatus.OK).body(entryset1);
}


@PutMapping("/employee/status/{employeeId}/{tripId}")
public ResponseEntity<BookingRequest> storeEmployeeStatus(@PathVariable("employeeId")int employeeID,@PathVariable("tripId")long tripCabID)
{
	// status = this.service.storeEmployeeStatus(employeeID);
	BookingRequest savedStatus = this.service.storeEmployeeStatus(employeeID);
	
	return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
}
//For updating the end status of cab
 @PutMapping("/updateme/{tripCabId}")
   public ResponseEntity<TripCabInfo> updatebytripCabID(@PathVariable("tripCabId")long tripCabID){
    	
    		 
    		TripCabInfo savedStatus = this.service.updateTrip(tripCabID); 
    	 
    	 
    	 
	return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
     }
 
 
 @PutMapping("/updateme/Ongoing/{tripCabId}")
 public ResponseEntity<TripCabInfo> updatebytripCabIDforOngoing(@PathVariable("tripCabId")long tripCabID){
	 System.out.print(tripCabID);
  		 
  		TripCabInfo savedStatus = this.service.updateTripforOngoing(tripCabID); 
  	 
  	 
  	 
	return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
   }

 @GetMapping(path = "/tripdetails/{id}")
	public ResponseEntity<List<TripCabInfo>> getTripDetails(@PathVariable("id")long tripCabID)
	{
		List<TripCabInfo> tripdetails = this.service.getTripDetails(tripCabID);
		
		return ResponseEntity.status(HttpStatus.OK).body(tripdetails);
	}
 
//For getting server time-startTime
@GetMapping("getServerTime/{tripCabID}")
public TripCabInfo getBookingTime(@PathVariable("tripCabID") long tripCabID)
{
return this.service.getBookingTime(tripCabID);
}

//this is kishore code
 //FOR DRIVER'S NOTIFICATION
@GetMapping(path="/notification")
public List<TripCabInfo> getNotification() {
	 return this.repofordrivernotification.findAll();
}

@GetMapping(path="/notification/{cabNumber}")
public TripCabInfo getNotificationByCabNumber(@PathVariable String cabNumber) {
	TripCabInfo tripObj = this.repofordrivernotification.getTripAssignedDetailsByCabNumber(cabNumber);
	return tripObj;
}



//FOR DRIVER PROFILES

@GetMapping(path="/driverProfile")
public List<DriverProfile> getDriverProfile() {
	 return this .repos.findAll();
}


@GetMapping(path="/driverProfile/{cabNumber}")
public DriverProfile getProfileByCabNumber(@PathVariable String cabNumber) {
	return this.repos.getDriverProfileByCabNumber(cabNumber);
}

//FOR ADMIN CONTACT DETAILS

@GetMapping(path="/adminContactDetails")
public List<AdminContacts> getAdminContacts(){
	return this.reposs.findAll();
	
}



























}
