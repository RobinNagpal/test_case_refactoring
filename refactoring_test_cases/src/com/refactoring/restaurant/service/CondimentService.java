package com.refactoring.restaurant.service;

import java.util.List;

import com.refactoring.restaurant.domain.Condiment;

public interface CondimentService {

	Condiment getCondimentWithName(String name);

	List<Condiment> getAllCondiments();

}
