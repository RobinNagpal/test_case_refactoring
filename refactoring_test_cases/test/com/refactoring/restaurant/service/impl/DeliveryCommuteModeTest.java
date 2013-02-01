package com.refactoring.restaurant.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.DeliveryStatus;
import com.refactoring.restaurant.domain.Item;
import com.refactoring.restaurant.domain.DeliveryStatus.CommuteMode;
import com.refactoring.restaurant.domain.mother.ItemMother;
import com.refactoring.restaurant.service.DeliveryService;

public class DeliveryCommuteModeTest {
	DeliveryService deliveryService = new DeliveryServiceImpl();
	int ONE_HOUR = 60 * 1000 * 60;
	
	DeliveryPackage deliveryPackage =null;
	@Before
	public void setup(){
		List<Item> items = ItemMother.getListOfItemsWithPrices(110f, 110f);
		deliveryPackage = deliveryService.getDeliveryPackageForItems(items);

	}
	
	@Test
	public void shouldDoNormalDeliveryOnCycle() {

		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		// verify
		Assert.assertEquals(CommuteMode.CYCLE, deliveryStatus.getCommuteMode());
	}
	
	@Test
	public void shouldDoExpediteDeliveryOnBike() {

		// exercise
		DeliveryStatus deliveryStatus = deliveryService.doExpediteDelivery(deliveryPackage);

		// verify
		Assert.assertEquals(CommuteMode.BIKE, deliveryStatus.getCommuteMode());

	}

}
