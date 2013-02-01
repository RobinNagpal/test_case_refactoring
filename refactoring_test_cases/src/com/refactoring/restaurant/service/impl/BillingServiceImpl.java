package com.refactoring.restaurant.service.impl;

import com.refactoring.restaurant.dao.BillingRepository;
import com.refactoring.restaurant.domain.Coupon;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.service.BillingService;

public class BillingServiceImpl implements BillingService {

	@Override
	public boolean isCouponCodeValid(String couponCode) {
		return false;
	}

	@Override
	public void doDicountForCoupon(Coupon coupon, DeliveryPackage deliveryPackage) {
	}

	@Override
	public float getBillWithTaxes(DeliveryPackage deliveryPackage) {
		return 0;
	}

	@Override
	public float getFoodBillWithTaxes(DeliveryPackage deliveryPackage) {
		return 0;
	}

	@Override
	public float getFoodBillWithTaxesAndDiscounts(DeliveryPackage deliveryPackage) {
		return 0;
	}
	
	void setBillingRepoitory(BillingRepository billingRepository){
		 
	}

	public float getBillWithDiscountForPackage(DeliveryPackage deliveryPackage) {
		return 0;
	}

}
