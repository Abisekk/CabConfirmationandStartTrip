package com.example.demo.Tripdetails;

//import java.util.List;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Document(collection = "Bookingrequest")

public class Tripdetails {
	
	@Id
	public int tripId ;
	Detailsonly details;
	Detailsonly details2;
	Detailsonly details3;
	
	
	
	
	
	
	
	
	

}
