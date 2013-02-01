package com.refactoring.restaurant.domain;

import java.util.List;

import com.refactoring.restaurant.domain.constants.FoodAversion;
import com.refactoring.restaurant.domain.constants.FoodType;

public class Item extends BaseEntity {

	private FoodType foodType;
	private List<FoodAversion> foodAversions;
	private String name;
	private float price;

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public List<FoodAversion> getFoodAversions() {
		return foodAversions;
	}

	public void setFoodAversions(List<FoodAversion> foodAversions) {
		this.foodAversions = foodAversions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
