/**
 * 
 * @author ashishaggarwal
 *
 *
 *This is a Main class that accepts the inputs and process on it.
 */
package com.nagarro.assignment1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.assignment1.input.ParseInput;
import com.nagarro.assignment1.model.Item;
import com.nagarro.assignment1.output.Output;


public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// This is the main function where the program starts.
		final List<Item> items = new ArrayList<>(); // Array of the objects of class Item

		// BufferedReader is a java class that enable the large reads
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		Item item = null; // Instance of a class
		char choice; // for yes and no
		String customerInput;
		double totalPrice = 0.0d;
		double effectivePriceAllTheItems = 0;
		try {
			do {
				System.out.println("\nEnter the Item Details in the following format:\r\n" 
						+ "-name      <first item name>\n"
						+ "-price     <price of first item>\n" 
						+ "-quantity  <quantity of first item>\n"
						+ "-type      <type of first item>(Choose Any one of the following(raw, imported and manufactured)\n"
						);
				customerInput = obj.readLine(); 			 // takes input line
				item = ParseInput.parseInput(customerInput); // Takes Input

				if (item != null) {
					item.calStl(); 								// calculate the sales tax for given type
					totalPrice = item.getQty() * item.getFppi(); 	// calculate the total price  
					item.setTotalPrice(totalPrice);	
					effectivePriceAllTheItems += item.getTotalPrice(); // Total sum
					items.add(item); // add item object in the items list
				}

				System.out.print("Do you want to enter another item details(Enter y/n) : ");
				choice = obj.readLine().charAt(0); //choice for adding the new item
			} while ((choice == 'y') || (choice == 'Y'));
		} catch (IOException e) {
			System.out.println("IO Error");
		}
		Output.displayResultFormat();// Display the format
		for (Item listItem : items) {
			Output.displayResult(listItem); // Display each item details
		}
		String str = String.format("\n%88.3f", effectivePriceAllTheItems); 
		System.out.println(str);//print the total amount
	}

}
