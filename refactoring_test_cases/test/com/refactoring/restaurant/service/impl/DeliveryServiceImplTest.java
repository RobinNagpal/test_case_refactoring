package com.refactoring.restaurant.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.refactoring.restaurant.domain.Condiment;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.DeliveryStatus;
import com.refactoring.restaurant.domain.DeliveryStatus.CommuteMode;
import com.refactoring.restaurant.domain.DeliveryStatus.STATUS;
import com.refactoring.restaurant.domain.Item;
import com.refactoring.restaurant.domain.mother.ItemMother;
import com.refactoring.restaurant.domain.verifiers.DeliveryPackageVerifier;
import com.refactoring.restaurant.service.CondimentService;
import com.refactoring.restaurant.service.DeliveryService;

public class DeliveryServiceImplTest {
	DeliveryService deliveryService = new DeliveryServiceImpl();

	@Test
	public void shouldChargeMoreForExpediteDelivery() {
		// setup
		float priceOfFood1 = 110f;
		float priceOfFood2 = 100f;
		List<Item> items = ItemMother.getListOfItemsWithPrices(priceOfFood1, priceOfFood2);
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		// exercise
		deliveryService.doExpediteDelivery(deliveryPackage);

		// verify
		Assert.assertEquals(priceOfFood1 + priceOfFood2 + 100, deliveryPackage.getPrice(), 0.1);

	}

	

	@Test
	public void shouldNotChargeMoreForExpediteDeliveryForGreaterPrice() {
		// setup
		float priceOfItem1 = 110f;
		float priceOfItem2 = 110f;
		float priceOfItem3 = 300f;
		
		List<Item> items = ItemMother.getListOfItemsWithPrices(priceOfItem1, priceOfItem2, priceOfItem3);
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		
		float sum = priceOfItem1+priceOfItem2+priceOfItem3;
		Assert.assertTrue(sum > 500);
		
		// exercise
		deliveryService.doExpediteDelivery(deliveryPackage);

		// verify
		Assert.assertEquals(sum, deliveryPackage.getPrice() , 0.1);
		

	}

	@Test
	public void shouldNotChargeForNormalDelivery() {
		// setup
		List<Item> items = ItemMother.getListOfItemsWithPrices(110f, 110f);
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		// exercise
		 deliveryService.doExpediteDelivery(deliveryPackage);

		// verify
		Assert.assertEquals(220, deliveryPackage.getPrice());

	}
	


	@Test
	public void testStopDelivery() {
		// setup
		List<Item> items = ItemMother.getListOfItems();
		DeliveryPackage deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		// verify
		Assert.assertEquals(STATUS.NOT_ACCEPTED, deliveryStatus.getStatus());
		Assert.assertEquals(CommuteMode.CYCLE, deliveryStatus.getCommuteMode());

	}

	@Test
	public void testGetVegDeliveryPackageForItems() {
		// setup
		List<Item> vegItems = ItemMother.getVegItems();
		CondimentService condimentService = mock(CondimentService.class);
		initializeCondimentService(condimentService);

		// exercise
		DeliveryPackage deliveryPackage = deliveryService.getVegDeliveryPackageForItems(vegItems);

		// verify
		DeliveryPackageVerifier.verifyThatItContainsAllVegetarianCondiments(deliveryPackage);

	}

	@Test
	public void testGetVeganDeliveryPackageForItems() {
		// setup
		List<Item> veganItems = ItemMother.getListOfTwoVeganItems();
		CondimentService condimentService = mock(CondimentService.class);
		initializeCondimentService(condimentService);

		// exercise
		DeliveryPackage deliveryPackage = deliveryService.getVeganDeliveryPackageForItems(veganItems);

		// verify
		DeliveryPackageVerifier.verifyThatItContainsOnlyVeganCondiments(deliveryPackage);

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
