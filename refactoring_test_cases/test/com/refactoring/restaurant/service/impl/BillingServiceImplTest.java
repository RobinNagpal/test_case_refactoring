package com.refactoring.restaurant.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.refactoring.restaurant.dao.BillingRepository;
import com.refactoring.restaurant.dao.CouponRepository;
import com.refactoring.restaurant.dao.DeliveryStatusRepository;
import com.refactoring.restaurant.domain.Coupon;
import com.refactoring.restaurant.domain.DeliveryPackage;
import com.refactoring.restaurant.domain.Item;
import com.refactoring.restaurant.domain.constants.FoodAversion;
import com.refactoring.restaurant.domain.constants.FoodType;

public class BillingServiceImplTest {

	BillingServiceImpl billingService = new BillingServiceImpl();
	DeliveryServiceImpl deliveryService= new DeliveryServiceImpl();
	 
	DeliveryPackage deliveryPackage; 
	
	@Before
	public void setup(){
		
		BillingRepository billingRepository = mock (BillingRepository.class);
		billingService.setBillingRepoitory(billingRepository);

		DeliveryStatusRepository  deliveryStatusRepository =mock(DeliveryStatusRepository.class);
		deliveryService.setDeliveryStatusRepository(deliveryStatusRepository);

		List<Item> items = new ArrayList<Item>();
		for (int i =0; i<10; i++){
			Item item = new Item();
			item.setId(i * 10l );
			item.setFoodType(FoodType.MAIN_COURSE);
			item.setName( "Item Name" + i);
			items.add(item);
			item.setPrice(303f);
		}

		deliveryPackage.setItems(items);
		deliveryPackage.setId(404l);
		deliveryPackage.setActive(true);

		
		CouponRepository couponRepository = mock(CouponRepository.class);
		
		Coupon coupon=new Coupon();
		coupon.setId(35l);
		coupon.setActive(true);
		String code = "FRIEND25";
		coupon.setCode(code);
		when(couponRepository.getCouponById(35)).thenReturn(coupon);
		
	}

	public void testGetFoodBillWithTaxesAndDiscounts() {

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

		DeliveryPackage deliveryPackage = new DeliveryPackage();
		deliveryPackage.setItems(items);

		float bill = billingService.getFoodBillWithTaxesAndDiscounts(deliveryPackage);

		Assert.assertEquals(220, deliveryPackage.getPrice());
		Assert.assertEquals(220f, bill, 0.1);
	}

	
	public void testGetFoodBillWithTaxesAndDiscounts1() {

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

		DeliveryPackage deliveryPackage = new DeliveryPackage();
		deliveryPackage.setItems(items);

		float bill = billingService.getFoodBillWithTaxesAndDiscounts(deliveryPackage);

		Assert.assertEquals(520, deliveryPackage.getPrice());
		Assert.assertEquals(420f, bill, 0.1);

	}
	
	@Test
	public void testGetBillForDeliveryPackage(){
		float bill = billingService.getBillWithDiscountForPackage(deliveryPackage);
		Assert.assertTrue(bill< 2500);
	}

}
