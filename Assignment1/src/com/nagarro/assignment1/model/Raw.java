package com.nagarro.assignment1.model;

import com.nagarro.assignment1.constants.Constants;
import com.nagarro.assignment1.model.Item;

/**
 * 
 * @author ashishaggarwal
 * 
 * This Raw class extends the Item class with cal_stl function for calculating the tax.
 */

public class Raw extends Item
{
	/**
	 * 
	 * @param name
	 * @param type
	 * @param price
	 * @param qty
	 */
public Raw(String name,Double price, int qty) {
	super(name,price, qty);
}
/*
 * (non-Javadoc)
 * @see com.nagarro.assignment1.Model.Item#cal_stl()
 * 
 * Raw Tax Rule :  12.5% of item price 
 */
@Override
public void calStl() 
{
	salesTax = Constants.RAW_TAX_RATE * unitPrice; 
	subTotal = unitPrice + salesTax  ;	
}
}

