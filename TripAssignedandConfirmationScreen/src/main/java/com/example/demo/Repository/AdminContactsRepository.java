package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Tripdetails.AdminContacts;



@Repository
public interface AdminContactsRepository extends MongoRepository<AdminContacts, Integer> {

	

}
