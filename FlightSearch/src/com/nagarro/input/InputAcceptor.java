package com.nagarro.input;

import com.nagarro.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class InputAcceptor{
public static UserInput enterData() throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String source, destination,flightClass;
	Date travelDate;
	int outputPreference;
	
	// Input that user enters to search the flights
	System.out.println("Departure Location :");
	while((source = InputValidator.ValidateSource(br.readLine()))==null) {continue;}
	
	System.out.println("Arrival Location :");
	while((destination = InputValidator.ValidateDestination(br.readLine()))==null) {continue;}
	
	System.out.println("Travel Date (DD-MM-YYYY):");
	while((travelDate = InputValidator.ValidateDate(br.readLine()))==null) {continue;}

	System.out.println("Class [Economic-E or Business-B]:");
	while((flightClass = InputValidator.ValidateClass(br.readLine()))==null) {continue;}
	
	System.out.println("Output Preference :");
	while((outputPreference = InputValidator.ValidatePreference(Integer.parseInt(br.readLine()))) == 0) {continue;}
	return new UserInput(source, destination, travelDate, flightClass, outputPreference);
	
}

}
