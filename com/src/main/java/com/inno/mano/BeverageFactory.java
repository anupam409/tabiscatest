package com.inno.mano;

import java.util.HashMap;
import java.util.Map;

public class BeverageFactory {
	private static final Map<String, Double> menuItemsPrices = new HashMap<>();
	private static final Map<String, Double> ingredientPrices = new HashMap<>();

public Double totalOrderedAmount(String ordered) {

		Double price = 0d;
		for (String order : getOrderPlaced(ordered)) {
			if (order.startsWith("-")) {
				price = price - getOrderPlacedPrice().get(order.substring(1));
			} else {
				price = price + getOrderPlacedPrice().get(order);
			}
		}
		return price;
	}

	public String[] getOrderPlaced(String orderValue) {
		return orderValue.split(",");
	}

	public Map<String, Double> getOrderPlacedPrice() {
		ingredientPrices.put("milk", 1d);
		ingredientPrices.put("sugar", 0.5);
		ingredientPrices.put("soda", 0.5);
		ingredientPrices.put("mint", 0.5);
		ingredientPrices.put("water", 0.5);

		menuItemsPrices.put("coffee", 5d);
		menuItemsPrices.put("chai", 4d);
		menuItemsPrices.put("banana smoothie", 6d);
		menuItemsPrices.put("stawberry shake", 7d);
		menuItemsPrices.putAll(ingredientPrices);

		return menuItemsPrices;
	}
}
