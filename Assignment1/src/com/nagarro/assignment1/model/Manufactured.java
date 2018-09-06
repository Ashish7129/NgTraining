package com.nagarro.assignment1.model;

import com.nagarro.assignment1.constants.Constants;
/**
 * 
 * @author ashishaggarwal
 *
 * This Manufactured class extends the Item class with cal_stl function for calculating the tax.
 */
public class Manufactured extends Item {
	/**
	 * 
	 * @param name
	 * @param type
	 * @param price
	 * @param qty
	 */
	public Manufactured(String name,Double price, int qty) {
		super(name,price, qty);
	}
	/*
	 * (non-Javadoc)
	 * @see com.nagarro.assignment1.Model.Item#cal_stl()
	 * 
	 *Manufactured Tax Rule:12.5% of the item cost + 2% of (item cost + 12.5% of item cost)
	 */
	@Override
	public void calStl() 
	{
		salesTax = Constants.MANUFACTURED_TAX_RATE* unitPrice + (1+Constants.MANUFACTURED_TAX_RATE) * unitPrice * Constants.SURCHRGE_RATE_MANUFACTURED; 
		subTotal = unitPrice + salesTax ;
	}
	}
