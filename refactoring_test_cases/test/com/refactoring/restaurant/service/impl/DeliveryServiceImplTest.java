package com.refactoring.restaurant.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Assert;
import com.refactoring.restaurant.domain.Condiment;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.DeliveryStatus;
import com.refactoring.restaurant.domain.DeliveryStatus.CommuteMode;
import com.refactoring.restaurant.domain.DeliveryStatus.STATUS;
import com.refactoring.restaurant.domain.Item;
import com.refactoring.restaurant.domain.constants.FoodAversion;
import com.refactoring.restaurant.domain.mother.ItemMother;
import com.refactoring.restaurant.service.CondimentService;
import com.refactoring.restaurant.service.DeliveryService;

public class DeliveryServiceImplTest {
	DeliveryService deliveryService = new DeliveryServiceImpl();

	
	public void testDoExpediteDelivery() {
		// setup 
		List<Item> items = ItemMother.getListOfItemsWithPrices(110f, 100f);
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		
		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		
		// verify
		Assert.assertEquals(310, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 30 * 1000 * 60);
		Assert.assertEquals(CommuteMode.BIKE, deliveryStatus.getCommuteMode());

	}

	public void testDoExpediteDelivery1() {
		// setup 
		List<Item> items = ItemMother.getListOfItemsWithPrices(110f, 110f,300f);
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		
		// verify
		Assert.assertEquals(520, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 30 * 1000 * 60);
		Assert.assertEquals(CommuteMode.BIKE, deliveryStatus.getCommuteMode());

	}

	public void testDoNormalDelivery() {
		// setup 
		List<Item> items = ItemMother.getListOfItemsWithPrices(110f, 110f);
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		
		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		
		// verify
		Assert.assertEquals(220, deliveryPackage.getPrice());
		Assert.assertTrue(deliveryStatus.getTimeTaken() < 2 * 60 * 1000 * 60);
		Assert.assertEquals(CommuteMode.CYCLE, deliveryStatus.getCommuteMode());

	}

	public void testStopDelivery() {
		// setup 
		List<Item> items = ItemMother.getListOfItems();
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		
		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		
		// verify
		Assert.assertEquals(STATUS.NOT_ACCEPTED, deliveryStatus.getStatus() );
		Assert.assertEquals(CommuteMode.CYCLE, deliveryStatus.getCommuteMode());

	}


	public void testGetVegDeliveryPackageForItems() {
		// setup 
		List<Item> items = ItemMother.getVegItems();
		CondimentService condimentService = mock(CondimentService.class);
		initializeCondimentService(condimentService);

		// exercise
		DeliveryPackage deliveryPackage = deliveryService.getVegDeliveryPackageForItems(items);

		
		// verify
		List<Condiment> condiments = deliveryPackage.getCondiments();
		for (Condiment vegCondiment : condiments) {
			for (FoodAversion foodAversion : vegCondiment.getFoodAversions()) {
				Assert.assertTrue(foodAversion == FoodAversion.NON_VEG);
			}
		}

	}

	public void testGetVeganDeliveryPackageForItems() {
		// setup 
		List<Item> items = ItemMother.getListOfTwoVegItems();
		CondimentService condimentService = mock(CondimentService.class);
		initializeCondimentService(condimentService);

		// exercise
		DeliveryPackage deliveryPackage = deliveryService.getVeganDeliveryPackageForItems(items);

		// verify
		List<Condiment> condiments = deliveryPackage.getCondiments();
		for (Condiment veganCondiment : condiments) {
			for (FoodAversion foodAversion : veganCondiment.getFoodAversions()) {
				Assert.assertTrue(foodAversion == FoodAversion.VEG || foodAversion == FoodAversion.NON_VEG);
			}
		}

	}

	public void initializeCondimentService(CondimentService condimentService) {
		Condiment condiment = new Condiment();
		condiment.setName("Mayo");
		condiment.setWeight(20f);
		when(condimentService.getCondimentWithName("Mayo")).thenReturn(condiment);

		Condiment condiment1 = new Condiment();
		condiment1.setName("Ketchup");
		condiment1.setWeight(20f);
		when(condimentService.getCondimentWithName("Ketchup")).thenReturn(condiment1);
		
		Condiment condiment2 = new Condiment();
		condiment2.setName("Mustard");
		condiment2.setWeight(20f);
		when(condimentService.getCondimentWithName("Mustard")).thenReturn(condiment2);
	}

}
