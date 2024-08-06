package com.cognizant.truyum.model;

import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

	public Cart(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuItemList == null) ? 0 : menuItemList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		// Replaced if-then-else statement with a single return statement
		return (this == obj) 
				|| (obj != null && getClass() == obj.getClass() && ((Cart) obj).menuItemList.equals(menuItemList)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(((Cart) obj).total));
	}
	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}
	
}
