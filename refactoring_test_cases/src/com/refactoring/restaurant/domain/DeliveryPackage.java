package com.refactoring.restaurant.domain;

import java.util.List;

public class DeliveryPackage extends BaseEntity {
	
	private List<Item> items;

	private List<Condiment> condiments;
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getPrice() {
		float priceOfAllItems = 0f;
		for (Item item:items){
			priceOfAllItems +=item.getPrice();
		}
		
		return Math.round(priceOfAllItems);
	}

	public List<Condiment> getCondiments() {
		return condiments;
	}

	public void setCondiments(List<Condiment> condiments) {
		this.condiments = condiments;
	}

	
	
}
