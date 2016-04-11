package com.rbc.test;

public enum Items {
	Bananas(0.75), Oranges(1), Apples(2), Lemons(0.5), Peaches(1.25);
	
	private double price; 
	
	Items(double rate) {
		this.price = rate;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double rate) {
		this.price = rate;
	}
}
