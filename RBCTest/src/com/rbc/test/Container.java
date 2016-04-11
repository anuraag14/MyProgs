package com.rbc.test;

import java.util.List;
import java.util.Map;

public class Container {

	public double getTotalCost(List<Items> bucket) {
		return bucket.stream().mapToDouble(i -> i.getPrice()).sum();
	}

	public double getTotalCost(Map<Items, Integer> bucket) {
		return bucket.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue().intValue()).sum();
	}
	
}
