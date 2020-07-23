package com.inno.mano;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BeverageFactoryTest {
	private BeverageFactory beverageFactory;
	private Map<String, Double> menuItemsPrices;

	@Before
	public void setUp() throws Exception {
		beverageFactory = new BeverageFactory();
		menuItemsPrices = new HashMap<>();
	}

	@Test
	public void getTotalOrderedAmountTest() {
		Double response = beverageFactory.totalOrderedAmount("chai,-sugar");
		assertEquals(response, 3.5, 0);
		Double respose2 = beverageFactory.totalOrderedAmount("chai,-sugar,-milk");
		assertEquals(respose2, 2.5, 0);
		Double respose3 = beverageFactory.totalOrderedAmount("chai");
		assertEquals(respose3, 4.0, 0);
		Double respose4 = beverageFactory.totalOrderedAmount("chai,-sugar,chai,coffee,milk");
		assertEquals(respose4, 13.5, 0);
	}

	@Test
	public void getOrderPlacedTest() {
		String[] orderedPlaced = beverageFactory.getOrderPlaced("chai,-sugar");
		assertEquals(orderedPlaced[0], "chai");
		assertEquals(orderedPlaced[1], "-sugar");
		assertEquals(orderedPlaced[0] + "," + orderedPlaced[1], "chai,-sugar");

		String[] orderedPlaced2 = beverageFactory.getOrderPlaced("chai,-sugar,-milk");
		assertEquals(orderedPlaced2[0], "chai");
		assertEquals(orderedPlaced2[1], "-sugar");
		assertEquals(orderedPlaced2[2], "-milk");
		assertEquals(orderedPlaced2[0] + "," + orderedPlaced[1] + "," + orderedPlaced2[2], "chai,-sugar,-milk");

		String[] orderedPlaced3 = beverageFactory.getOrderPlaced("chai");
		assertEquals(orderedPlaced3[0], "chai");

		String[] orderedPlaced4 = beverageFactory.getOrderPlaced("chai,-sugar,chai,coffee,milk");
		assertEquals(orderedPlaced4[0], "chai");
		assertEquals(orderedPlaced4[1], "-sugar");
		assertEquals(orderedPlaced4[2], "chai");
		assertEquals(orderedPlaced4[3], "coffee");
		assertEquals(orderedPlaced4[4], "milk");
		assertEquals(orderedPlaced4[0] + "," + orderedPlaced4[1] + "," + orderedPlaced4[2] + "," + orderedPlaced4[3]
				+ "," + orderedPlaced4[4], "chai,-sugar,chai,coffee,milk");
	}

	public void getOrderPlacedPriceTest() {
		menuItemsPrices = beverageFactory.getOrderPlacedPrice();
	}

}
