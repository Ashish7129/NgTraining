package com.nagarro.assignment1.input;

import com.nagarro.assignment1.constants.Constants;
/**
 * 
 * @author ashishaggarwal
 *
 *This Validation class helps to validate the different type of strings
 */
public final class Validation {

	/**
	 * 
	 * @param str
	 * @return
	 */
	//CheckDouble checks the string content as double 
	public static boolean checkDouble(String str) {	
		boolean flag = false; 
		try {
			Double.parseDouble(str); //checks whether str value's type is double or not
			flag = true;
		}
		catch (NumberFormatException e) {
			System.out.println("You entered the Item price in wrong format, kindly enter in Double Format");
		}
		return flag;
	}

	
/**
 * 
 * @param str
 * @return
 */
	//CheckItemType function Checks the string content matches the itemType or not
	public static boolean checkItemType(String str) 
	{
			boolean flag = false;
			//checks str value equals to which type of an item
			if (str.equalsIgnoreCase(Constants.RAW)|str.equalsIgnoreCase(Constants.MANUFACTURED)|str.equalsIgnoreCase(Constants.IMPORTED))
			{
				flag = true; //sets flag equals to true
			}
			else {
			System.out.println("You entered the item type in wrong format. kindly enter again \nEnter one of the following (raw,manufactured,imported))");
			}
			return flag;
		}
/**
 * 
 * @param str
 * @return 
 */
	//CheckInt checks the string content as Integer
	public static boolean checkInt(String str) {
		boolean flag = false;
		try
		{
			Integer.parseInt(str); //checks whether str value's type is Integer or not
			flag = true;
		} 
		catch (NumberFormatException e) 
		{
			System.out.println("You Entered the Quantity in wrong format, kindly enter in Integer Format.");
		}
	return flag;
	}

}