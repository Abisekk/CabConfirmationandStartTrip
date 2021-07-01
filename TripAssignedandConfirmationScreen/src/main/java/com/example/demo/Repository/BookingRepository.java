package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;


import org.bson.types.ObjectId;
//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Tripdetails.BookingRequest;
import com.example.demo.Tripdetails.Tripdetails;

//import com.example.Tripdetails.PaymentHistory;

public interface BookingRepository extends MongoRepository<BookingRequest, Long> {

	
	
	 public Optional<List<BookingRequest>> findByTripCabId(long srchid);
	Optional<BookingRequest> findByEmployeeId(long id);
	
	
	Optional<BookingRequest> findByEmployeeIdAndTripCabId(int empId,long id);
	
	
}




























