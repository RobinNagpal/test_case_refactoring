package com.refactoring.restaurant.domain;

import java.util.List;

import com.refactoring.restaurant.domain.constants.FoodAversion;

public class Condiment extends BaseEntity {
	private String name;
	private float weight;
	private List<FoodAversion> foodAversions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<FoodAversion> getFoodAversions() {
		return foodAversions;
	}

	public void setFoodAversions(List<FoodAversion> foodAversions) {
		this.foodAversions = foodAversions;
	}

}
