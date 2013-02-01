package com.refactoring.restaurant.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.refactoring.restaurant.domain.Condiment;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.DeliveryStatus;
import com.refactoring.restaurant.domain.DeliveryStatus.CommuteMode;
import com.refactoring.restaurant.domain.Item;
import com.refactoring.restaurant.domain.constants.FoodAversion;
import com.refactoring.restaurant.service.CondimentService;
import com.refactoring.restaurant.service.DeliveryService;

public class DeliveryServiceImplTest {
	DeliveryService deliveryService = new DeliveryServiceImpl();

	public void testDoExpediteDelivery() {

		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Chicken Burger");
		item1.setPrice(100f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);

		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);
		deliveryPackage.setItems(items);

		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		Assert.assertEquals(310, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 30 * 1000 * 60);
		Assert.assertEquals(CommuteMode.BIKE, deliveryStatus.getCommuteMode());

	}

	public void testDoExpediteDelivery1() {

		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Chicken Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		Item item2 = new Item();
		item2.setId(30l);
		item2.setName("Chicken Burger");
		item2.setPrice(300f);
		FoodAversion[] foodAversions2 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions2));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);
		items.add(item2);

		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		Assert.assertEquals(520, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 30 * 1000 * 60);
		Assert.assertEquals(CommuteMode.BIKE, deliveryStatus.getCommuteMode());

	}

	public void testDoNormalDelivery() {

		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Chicken Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);

		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		Assert.assertEquals(220, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 2 * 60 * 1000 * 60);
		Assert.assertEquals(CommuteMode.CYCLE, deliveryStatus.getCommuteMode());

	}

	public void testStopDelivery() {

		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Chicken Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);

		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		Assert.assertEquals(220, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 2 * 60 * 1000 * 60);
		Assert.assertEquals(CommuteMode.CYCLE, deliveryStatus.getCommuteMode());

	}

	public void testGetDeliveryPackageForItems() {
		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Chicken Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);

		CondimentService condimentService = mock(CondimentService.class);

		Condiment condiment = new Condiment();
		condiment.setName("Mayo");
		condiment.setWeight(20f);
		when(condimentService.getCondimentForItem(item)).thenReturn(condiment);

		Condiment condiment1 = new Condiment();
		condiment1.setName("Mustard");
		condiment1.setWeight(20f);
		when(condimentService.getCondimentForItem(item1)).thenReturn(condiment1);

		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		Assert.assertTrue(deliveryPackage.getItems().contains(item));
		Assert.assertTrue(deliveryPackage.getItems().contains(item1));

		Assert.assertTrue(deliveryPackage.getCondiments().contains(condiment));
		Assert.assertTrue(deliveryPackage.getCondiments().contains(condiment1));

	}

	public void testGetVegDeliveryPackageForItems() {
		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Veg Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);

		CondimentService condimentService = mock(CondimentService.class);

		Condiment condiment = new Condiment();
		condiment.setName("Mayo");
		condiment.setWeight(20f);
		when(condimentService.getCondimentForItem(item)).thenReturn(condiment);

		Condiment condiment1 = new Condiment();
		condiment1.setName("Mustard");
		condiment1.setWeight(20f);
		when(condimentService.getCondimentForItem(item1)).thenReturn(condiment1);

		DeliveryPackage deliveryPackage = deliveryService.getVegDeliveryPackageForItems(items);

		List<Condiment> condiments = deliveryPackage.getCondiments();

		for (Condiment vegCondiment : condiments) {
			for (FoodAversion foodAversion : vegCondiment.getFoodAversions()) {
				Assert.assertTrue(foodAversion == FoodAversion.NON_VEG);
			}
		}

	}

	public void testGetVeganDeliveryPackageForItems() {
		Item item = new Item();
		item.setId(20l);
		item.setName("French Fries");
		item.setPrice(110f);
		FoodAversion[] foodAversions = { FoodAversion.VEG, FoodAversion.VEGAN };
		item.setFoodAversions(Arrays.asList(foodAversions));

		Item item1 = new Item();
		item1.setId(30l);
		item1.setName("Veg Burger");
		item1.setPrice(110f);
		FoodAversion[] foodAversions1 = { FoodAversion.NON_VEG };
		item1.setFoodAversions(Arrays.asList(foodAversions1));

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		items.add(item1);

		CondimentService condimentService = mock(CondimentService.class);

		Condiment condiment = new Condiment();
		condiment.setName("Mayo");
		condiment.setWeight(20f);
		when(condimentService.getCondimentForItem(item)).thenReturn(condiment);

		Condiment condiment1 = new Condiment();
		condiment1.setName("Mustard");
		condiment1.setWeight(20f);
		when(condimentService.getCondimentForItem(item1)).thenReturn(condiment1);

		DeliveryPackage deliveryPackage = deliveryService.getVeganDeliveryPackageForItems(items);

		List<Condiment> condiments = deliveryPackage.getCondiments();
		for (Condiment veganCondiment : condiments) {
			for (FoodAversion foodAversion : veganCondiment.getFoodAversions()) {
				Assert.assertTrue(foodAversion == FoodAversion.VEG || foodAversion == FoodAversion.NON_VEG);
			}
		}

	}

}
