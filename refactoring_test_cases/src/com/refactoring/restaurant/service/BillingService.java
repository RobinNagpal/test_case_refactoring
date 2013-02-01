package com.refactoring.restaurant.service;

import com.refactoring.restaurant.domain.Coupon;
import com.refactoring.restaurant.domain.DeliveryPackage;

public interface BillingService {
	
	boolean isCouponCodeValid(String couponCode);

	void doDicountForCoupon(Coupon coupon, DeliveryPackage deliveryPackage);
	
	float getBillWithTaxes(DeliveryPackage deliveryPackage);
	
	float getFoodBillWithTaxes(DeliveryPackage deliveryPackage);
	
	float getFoodBillWithTaxesAndDiscounts(DeliveryPackage deliveryPackage);

	
	
}
