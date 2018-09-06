package com.nagarro.assignment1.input;

import java.io.IOException;

import com.nagarro.assignment1.constants.Constants;
import com.nagarro.assignment1.model.Item;
import com.nagarro.assignment1.model.Raw;
import com.nagarro.assignment1.model.Imported;
import com.nagarro.assignment1.model.Manufactured;
/**

 * @author ashishaggarwal
 * 
 * ParseInput class which helps to parse the customer input and return itemtype object.
 */
public class ParseInput {
	/**
	 * 
	 * @param enterString
	 * @return class Item
	 * @throws IOException
	 * 
	 */
	public static Item parseInput(String enterString) throws IOException
	{
		
		String name = Constants.BLANK_SPACE; 
		String type = Constants.BLANK_SPACE;
		Double price = 0.0d;
		int qty = 0;
		Item it =null;
		boolean valid = false;
		
		// Spliting the user input by hyphen
		String[] itemString = enterString.split(Constants.HYPHEN);
		
		//checks whether the input starts from the "name" and itemString must be of length five
		if ("name".equals(itemString[1].split(Constants.BLANK_SPACE)[Constants.ZERO])&& itemString.length == Constants.FIVE) {

			for (int i = 1; i < itemString.length; i++) {
				String[] temp = new String[Constants.TWO];
				//Two splits in the string by blank space.
				temp = itemString[i].split(Constants.BLANK_SPACE, Constants.NUMBER_SPLIT);
				
				//remove the spaces from starts or ends.
				temp[Constants.ZERO] = temp[Constants.ZERO].trim(); 
				temp[Constants.ONE] = temp[Constants.ONE].trim();
				
				//check the strings and update the values of declared variables
				if ("name".equals(temp[Constants.ZERO])) {
					name = temp[Constants.ONE];
				} 
				else if ("type".equals(temp[Constants.ZERO])) 
				{
					valid = Validation.checkItemType(temp[Constants.ONE]);
					if (valid) {
						type = temp[Constants.ONE].toLowerCase();}
				} 
				else if ("quantity".equals(temp[Constants.ZERO]))
				{
					valid = Validation.checkInt(temp[Constants.ONE]);
					if(valid) 
					{
						qty = Integer.parseInt(temp[Constants.ONE]);
					}	
				} 
				else if ("price".equals(temp[Constants.ZERO])) 
				{
					valid = Validation.checkDouble(temp[Constants.ONE]);
					if (valid) {
						price = Double.parseDouble(temp[Constants.ONE]);}
				}
			}
				if (valid) {
					if(type.equals(Constants.RAW)) // Raw Type
					{
						it = new Raw(name, price, qty);
					}
					else if(type.equals(Constants.MANUFACTURED)) // Manufactured Type
					{
						it = new Manufactured(name, price, qty);
					}
					else //Imported Type
					{
						it = new Imported(name,price, qty);

					}
				}
		} else {
			System.out.println("Kindly enter the item name first or check the hyphen format");
		}
		// System.out.println(type);
		return it;
	}
}
	
