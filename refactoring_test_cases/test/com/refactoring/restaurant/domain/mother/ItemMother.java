package com.refactoring.restaurant.domain.mother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.refactoring.restaurant.domain.Item;
import com.refactoring.restaurant.domain.constants.FoodAversion;

public class ItemMother {

	public static List<Item> getListOfTwoVegItems() {
		Item item = ItemMother.getFrenchFries();
	
		Item item1 = ItemMother.getVegBurger();
	
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);
		return items;
	}

	public static Item getVegBurger() {
		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Veg Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { };
		item1.setFoodAversions(Arrays.asList(foodAversions1));
		return item1;
	}

	public static Item getFrenchFries() {
		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { };
		item.setFoodAversions(Arrays.asList(foodAversions));
		return item;
	}

	public static Item getFoodWithPrice(float price1) {
		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(price1);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));
		return item;
	}

	public static List<Item> getListOfItemsWithPrices(float... prices) {
		List<Item> items = new ArrayList<Item>();
		for(float price : prices){
			Item item = getFoodWithPrice(price);
			items.add(item);
		}
		return items;
	}
	
	public static List<Item> getListOfItems() {
		List<Item> items = new ArrayList<Item>();
		for(float price : new float[]{110f, 120f,130f }){
			Item item = getFoodWithPrice(price);
			items.add(item);
		}
		return items;
	}

	public static Item getChickenBurger() {
		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Chicken Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));
		return item1;
	}

	public static Item getSmoothie() {
		Item item = new Item();
		item.setId(20l);
		item.setName("Smoothie");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG };
		item.setFoodAversions(Arrays.asList(foodAversions));
		return item;
	}

	public static List<Item> getVegItems() {
		Item smoothie = getSmoothie();
		Item vegBurger = getVegBurger();
	
		List<Item> items = new ArrayList<Item>();
		items.add(smoothie);
		items.add(vegBurger);
		return items;
	}

}
