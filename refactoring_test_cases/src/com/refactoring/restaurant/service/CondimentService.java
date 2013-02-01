package com.refactoring.restaurant.service;

import java.util.List;

import com.refactoring.restaurant.domain.Condiment;
import com.refactoring.restaurant.domain.Item;

public interface CondimentService {

	Condiment getCondimentForItem(Item item);

	List<Condiment> getAllCondiments();

}
