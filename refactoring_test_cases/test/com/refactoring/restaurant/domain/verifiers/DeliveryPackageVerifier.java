package com.refactoring.restaurant.domain.verifiers;

import java.util.List;

import org.junit.Assert;

import com.refactoring.restaurant.domain.Condiment;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.constants.FoodAversion;
import com.refactoring.restaurant.service.CondimentService;

public class DeliveryPackageVerifier {
	static CondimentService condimentService = null;

	public static void verifyThatItContainsAllTheCondiments(DeliveryPackage deliveryPackage) {
		List<Condiment> condiments = condimentService.getAllCondiments();
		Assert.assertTrue(deliveryPackage.getCondiments().containsAll(condiments));
	}

	public static void verifyThatItContainsOnlyVeganCondiments(DeliveryPackage deliveryPackage) {
		List<Condiment> condiments = deliveryPackage.getCondiments();
		for (Condiment condiment : condiments) {
			for (FoodAversion foodAversion : condiment.getFoodAversions()) {
				Assert.assertTrue(foodAversion == FoodAversion.VEG || foodAversion == FoodAversion.NON_VEG);
			}
		}
	}

	public static void verifyThatItContainsOnlyVegetarianCondiments(DeliveryPackage deliveryPackage) {

		List<Condiment> condiments = deliveryPackage.getCondiments();
		for (Condiment condiment : condiments) {
			for (FoodAversion foodAversion : condiment.getFoodAversions()) {
				Assert.assertTrue(foodAversion == FoodAversion.NON_VEG);
			}
		}
	}

	public static void verifyThatItContainsAllVegetarianCondiments(DeliveryPackage deliveryPackage) {

	}

	public static void verifyThatItContainsAllVeganCondiments(DeliveryPackage deliveryPackage) {

	}

}
