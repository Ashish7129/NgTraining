package com.nagarro.assignment1.output;

import com.nagarro.assignment1.model.Item;
/**
 * 
 * @author ashishaggarwal
 *
 *This class is for displaying the data on the console 
 */
public class Output
{ 	
	// display the format of the final result
	public static void displayResultFormat() {
		System.out.println("\n\n\nOutput:");
		String str = String.format("%-14s%-15s%-23s%-25s%-7s%-15s", "Name","Price","Sales Tax liability","Final Price per Item","Qty","Total Price");
		System.out.println(str);
	}
	
	//display the result
	public static void displayResult(Item i)
	{
		String str = String.format("%-14s%-15.3f%-23.3f%-25.3f%-7d%-15.3f", i.getName(),i.getPrice(),i.getStl(),i.getFppi(),i.getQty(),i.getTotalPrice());
		System.out.println(str);
	}
}