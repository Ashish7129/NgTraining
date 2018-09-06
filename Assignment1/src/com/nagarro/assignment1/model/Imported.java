package com.nagarro.assignment1.model;

import com.nagarro.assignment1.constants.Constants;
import com.nagarro.assignment1.model.Item;
/**
 * 
 * @author ashishaggarwal
 *
 * This Imported class extends the Item class with cal_stl function for calculating the tax.
 */

public class Imported extends Item {
	/**
	 * 
	 * @param name
	 * @param price
	 * @param qty
	 */
	public Imported(String name, Double price, int qty) {
		super(name, price, qty);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.nagarro.assignment1.Model.Item#cal_stl()
	 * Rule of the Imported Type Tax : 10% import duty + surcharge(depends on the subtotal amount)
	 */
	@Override
	public void calStl() 
	{
		salesTax = Constants.IMPORT_DUTY_IMPORTED* unitPrice;
		subTotal = unitPrice + salesTax;
		if (subTotal<=100)
		{
			salesTax += 5 ;
			subTotal+=5 ;
		}
		else if (subTotal<=200)
		{
			salesTax += 10 ;
			subTotal+=10 ;
		}
		else
		{
			subTotal = 1.05 * subTotal ;
			salesTax = subTotal - unitPrice ;
		}
	}
}