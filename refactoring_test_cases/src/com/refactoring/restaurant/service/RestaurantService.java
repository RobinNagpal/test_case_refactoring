package com.refactoring.restaurant.service;

import com.refactoring.restaurant.domain.Menu;

public interface RestaurantService {
	
	Menu getTodaysMenu();

	Menu getDrinksMenu();

	Menu getVegetarianMenu();

	Menu getLowPriceMenu();

}
