package com.rbc.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ContainerTest {

	private List<Items> it;
	private Map<Items, Integer> bucket;
	private Container classUnderTest;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		it = new ArrayList<Items>();
		bucket = new HashMap<Items, Integer>();
		classUnderTest = new Container();
	}

	@After
	public void tearDown() throws Exception {
		it = null;
		bucket = null;
		classUnderTest = null;
	}

	@Test
	public void testGetTotalCostWithList() {
		it.add(Items.Apples);
		it.add(Items.Bananas);
		it.add(Items.Peaches);
		it.add(Items.Apples);
		it.add(Items.Apples);
		it.add(Items.Bananas);
		it.add(Items.Lemons);
		double expectedTotalCost = 0;
		for (Items items : it) {
			expectedTotalCost += items.getPrice();
		}
		
		double actualTotalCost = classUnderTest.getTotalCost(it);
		assertEquals(expectedTotalCost, actualTotalCost, 0.0);
	}

	@Test
	public void testGetTotalCostWithMap() {
		bucket.put(Items.Apples, 15);
		bucket.put(Items.Bananas, 10);
		bucket.put(Items.Peaches, 10);
		bucket.put(Items.Lemons, 20);
		double expectedTotalCost = 0;
		for (Entry<Items, Integer> entry : bucket.entrySet()) { 
			expectedTotalCost += entry.getKey().getPrice() * entry.getValue().intValue();
		}
		
		double actualTotalCost = classUnderTest.getTotalCost(bucket);
		assertEquals(expectedTotalCost, actualTotalCost, 0.0);
	}
	
	@Test
	public void testGetTotalCostEmptyBucket() {
		double expectedTotalCost = 0;

		double actualTotalCost = classUnderTest.getTotalCost(it);
		assertEquals(expectedTotalCost, actualTotalCost, 0.0);
		
		actualTotalCost = classUnderTest.getTotalCost(bucket);
		assertEquals(expectedTotalCost, actualTotalCost, 0.0);	}
	
	@Test
	public void testGetTotalCostNullBucket() {
		bucket = null;
		thrown.expect(NullPointerException.class);
		classUnderTest.getTotalCost(bucket);
	}
	
	@Test
	public void testGetTotalCostNullItems() {
		it = null;
		thrown.expect(NullPointerException.class);
		classUnderTest.getTotalCost(it);
	}	

}
