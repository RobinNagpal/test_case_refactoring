package com.refactoring.restaurant.service;

import java.util.List;

import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.DeliveryStatus;
import com.refactoring.restaurant.domain.Item;

public interface DeliveryService {
	
	DeliveryStatus doExpediteDelivery(DeliveryPackage deliveryPackage );

	DeliveryStatus doNormalDelivery(DeliveryPackage deliveryPackage );
	
	DeliveryStatus stopDelivery(DeliveryPackage deliveryPackage);

	DeliveryPackage getDeliveryPackageForItems(List<Item> items);

	DeliveryPackage getVegDeliveryPackageForItems(List<Item> items);

	DeliveryPackage getVeganDeliveryPackageForItems(List<Item> items);
	
}
