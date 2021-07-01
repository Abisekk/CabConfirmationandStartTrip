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


import com.example.demo.Repository.BookingRepository;
import com.example.demo.Tripdetails.BookingRequest;
//import com.example.demo.Repository.TripRepository;
import com.example.demo.Tripdetails.Tripdetails;
import com.example.demo.service.TripService;

@RestController
public class Controller {

	@Autowired
	TripService service;
	private BookingRepository repo;
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
       @GetMapping(path="/Address/{TripId}")                           
public List<BookingRequest> getbytripid(@PathVariable("TripId") long srchid){
    	   Optional<List<BookingRequest>> book=this.service.findByTripCabId(srchid);
    	   //this.service.findByTripId(srchid);
		//return this.service.findByTripCabId(srchid);
		return book.get();
    	   
       }
//		Optional<Tripdetails> entity=Optional.ofNullable(repo.findByTripId(srchid));
//		
// //Stream<Tripdetails> filter = entity.stream().filter(e->e.getBillingAddress()).collect(toList());
//		entity.get( );
//		if(entity.isEmpty())
//			throw new NoSuchElementException();
//		
//		
//    	
//    	   return ResponseEntity.status(HttpStatus.CREATED).body(entity.get());
//}
//@PostMapping(path="/postone")
//public ResponseEntity<Tripdetails> addplan(@RequestBody Tripdetails entity){
//	
//	Tripdetails plan =repo.save(entity);
//	return ResponseEntity.status(HttpStatus.CREATED).body(plan);
//}
       @GetMapping(path="/Address/")                           
       public List<BookingRequest> getbytripid1(@RequestParam(value 	= "TripId") long srchid){
           	   Optional<List<BookingRequest>> book=this.service.findByTripCabId(srchid);
           	   //this.service.findByTripId(srchid);
       		//return this.service.findByTripCabId(srchid);
       		return book.get();
           	   
              }



//@PutMapping("/update/{TripId}")
//public ResponseEntity<BookingRequest> updatebyid(@PathVariable("TripId")Long id ,@RequestBody BookingRequest entryset){
//	List<BookingRequest> entity=repo.findByTripCabId(id);
//
//	BookingRequest bookingrequest=null;
//			bookingrequest.setStatus(entryset.getStatus());
////			Tripdetails.setBillingAddress(entryset.getBillingAddress());
////			Tripdetails.setResidenceAddress(entryset.getResidenceAddress());
//		this.repo.save(entryset);
//		return ResponseEntity.status(HttpStatus.OK).body(bookingrequest);
//		}
		//return entity;
		//return Optional.empty();
		




//



//@DeleteMapping(path="/Address/paymentaddress/{customerId}")
//public Optional<Tripdetails> deleterecord (@PathVariable("customerId") Long srchid){
//	
//	Optional<Tripdetails> deleteplan=this.repo.findById(srchid);
//	=
//	return this.repo.deleteById(deleteplan);
//}




     @PutMapping("/update/{employeeId}")
     public ResponseEntity<BookingRequest> updatebyid(@PathVariable("employeeId")Long id ,@RequestBody BookingRequest entryset){
     Optional<BookingRequest> entity=repo.findByEmployeeId(id);
     System.out.print(entity.get());
     	BookingRequest bookingrequest=null;
     	if(entity.isPresent()) {
 System.out.print("hi");
     		bookingrequest=entity.get();
     			bookingrequest.setStatus(entryset.getStatus());
//     			Tripdetails.setBillingAddress(entryset.getBillingAddress());
//     			Tripdetails.setResidenceAddress(entryset.getResidenceAddress());
     		this.repo.save(bookingrequest);
     	}
     		return ResponseEntity.status(HttpStatus.OK).body(bookingrequest);
     		}
    
  		

       

       
    
       

       
     @PutMapping("/update/for/{TripId}")
   public ResponseEntity<BookingRequest> updatebytripid(@PathVariable("TripId")Long id ,@RequestBody List<BookingRequest> entryset){
    	 System.out.print(entryset);
    	 for(BookingRequest each:entryset) {
    		 //BookingRequest bookingrequest= repo.findByEmployeeId(each.getEmployeeId()).get();
    		 BookingRequest bookingrequest= repo.findByEmployeeIdAndTripCabId(each.getEmployeeId(),id).get(); 
    		 
    		 if(!(bookingrequest.getStatus().equals("Cancelled"))) {
	    		 bookingrequest.setStatus("No-Show");
	    		 repo.save(bookingrequest);
    		 }
    		 
    		 
    	 }
    	 
    	 
    	 
	return null;
     }}
       
       
       
















