package com.nayan.service;

import java.util.List;

import com.nayan.model.Order;

public interface OrderService {
	public long stampProfileWithOrder(Order order);
	public List<Order> getAllOrderDetails();

	public String deleteProfile(long orderId);
}
