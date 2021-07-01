package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BookingRepository;
import com.example.demo.Tripdetails.BookingRequest;
//import com.example.demo.Repository.TripRepository;
import com.example.demo.Tripdetails.Tripdetails;

@Service(value="Service")
public class TripService {
	@Autowired
private BookingRepository repo;




public Optional<List<BookingRequest>> findByTripCabId(long srchid){
	return this.repo.findByTripCabId(srchid);
	
}


}
