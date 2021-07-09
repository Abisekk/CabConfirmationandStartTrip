package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.Tripdetails.BookingRequest;

//import com.example.Tripdetails.PaymentHistory;

public interface BookingRepository extends MongoRepository<BookingRequest, Long> {

	List<BookingRequest> findByTripCabIdAndStatus(long tripCabID, String status );
	
	 public Optional<List<BookingRequest>> findByTripCabId(long srchid);
	
	 
	 @Query(value="{tripCabId : ?0, status : 'OnProgress'}")
	 public Optional<List<BookingRequest>> findShowUsers(long srchid);
	 
	 

	
	 public Optional<List<BookingRequest>> findByStatus(String srchstatus);
	Optional<BookingRequest> findByEmployeeIdAndTripCabId(int empId,long id);
	
	
	
	 @Query(value="{employeeId:?0 ,status: 'OnProgress'}")
		BookingRequest findByEmployeeId(int employeeID);
	 
	
}




























