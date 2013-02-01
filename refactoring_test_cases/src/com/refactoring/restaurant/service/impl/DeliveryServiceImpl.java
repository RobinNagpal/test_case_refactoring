package com.refactoring.restaurant.service.impl;

import com.refactoring.restaurant.dao.DeliveryStatusRepository;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.DeliveryStatus;
import com.refactoring.restaurant.service.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService {

	@Override
	public DeliveryStatus doExpediteDelivery(DeliveryPackage deliveryPackage) {
		return null;
	}

	@Override
	public DeliveryStatus doNormalDelivery(DeliveryPackage deliveryPackage) {
		return null;
	}

	@Override
	public DeliveryStatus stopDelivery(DeliveryPackage deliveryPackage) {
		return null;
	}

	public void setDeliveryStatusRepository(DeliveryStatusRepository deliveryStatusRepository) {
		// TODO Auto-generated method stub
		
	}

}
