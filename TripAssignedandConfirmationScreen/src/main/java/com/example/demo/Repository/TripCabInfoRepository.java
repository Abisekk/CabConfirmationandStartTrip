package com.example.demo.Repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Tripdetails.TripCabInfo;



public interface TripCabInfoRepository extends MongoRepository<TripCabInfo, Long> {

	//List<TripCabInfo> findTripDetailsByTripCabID(long tripCabID);
	//List<TripCabInfo> findTripDetailsByTripCabID(long tripCabID);

	List<TripCabInfo> findTripDetailsByTripCabId(long tripCabId);
}
