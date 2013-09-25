package com.akhi.store.general;

import java.util.Map;
import java.util.TreeSet;

public class Order {

	private Map<Products, TreeSet<Double>> bag;

	private User user;

	private Double total;

	

	public Order(Map<Products, TreeSet<Double>> bag2, Double total) {
		super();
		this.bag = bag2;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [bag=" + bag + ", user=" + user + ", total=" + total
				+ "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Map<Products, TreeSet<Double>> getBag() {
		return bag;
	}

	public void setBag(Map<Products, TreeSet<Double>> bag) {
		this.bag = bag;
	}


}
