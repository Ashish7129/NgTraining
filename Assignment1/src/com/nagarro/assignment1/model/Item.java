package com.nagarro.assignment1.model;
/**
 * 
 * @author ashishaggarwal
 *
 * This is the Item Class which have accessors and mutators 
 */
public abstract class Item {
	protected String itemName;
	protected double unitPrice;
	protected int quantity;
	protected double salesTax;
	protected double subTotal;
	protected double total;
	/**
	 * 
	 * @param name
	 * @param type
	 * @param price
	 * @param qty
	 */
	public Item(final String name, final Double price, final int qty) {
		this.itemName = name;
		this.unitPrice = price;
		this.quantity = qty;
	}
	
	// for calculating the tax
	public abstract void calStl();

	// Accessor and mutators
	/**
	 * 
	 * @return
	 * This is a getter function for Item name
	 */
	public String getName() {
		return itemName;
	}
	/**
	 * 
	 * @param name
	 * * This is a setter function for Item name
	 */
	public void setName(String name) {
		this.itemName = name;
	}
	/**
	 * 
	 * @return
	 * * This is a getter function for Item cost
	 */
	public double getPrice() {
		return unitPrice;
	}
	/**
	 * 
	 * @param d
	 * * This is a setter function for Item cost
	 */
	public void setPrice(double d) {
		this.unitPrice = d;
	}
	/**
	 * 
	 * @return
	 * * This is a getter function for sales tax
	 */
	public double getStl() {
		return salesTax;
	}
	/**
	 * 
	 * @param qty
	 * * This is a setter function for Item quantity
	 */
	public void setQty(int qty) {
		this.quantity = qty;
	}
	/**
	 * 
	 * @return
	 * * This is a getter function for final price per Item
	 */
	public double getFppi() {
		return subTotal;
	}
	/**
	 * 
	 * @return
	 * * This is a getter function for Item quantity
	 */
	public int getQty() {
		return quantity;
	}
	/**
	 * 
	 * @return
	 * * This is a getter function for Total Price 
	 */
	public double getTotalPrice() {
		return total;
	}
	/**
	 * 
	 * @param total_Price
	 * * This is a setter function for Total Price
	 */
	public void setTotalPrice(double totalPrice) {
		this.total = totalPrice;
	}

}
