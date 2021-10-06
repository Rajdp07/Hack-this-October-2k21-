package com.nayan.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.nayan.DTO.ProfileModel;
import com.nayan.client.ProfileClient;
import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.Order;
import com.nayan.service.OrderServiceImpl;

@Repository
public class OrderDaoCache {
	public static final String HASH_KEY = "Order";

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate template;
	@Autowired
	private OrderServiceImpl service;
	@Autowired
	private ProfileClient client;

	public List<Order> getAllOrderDetails() {
		List<Order> orders = template.opsForHash().values(HASH_KEY);
		if (orders.isEmpty()) {
			return service.getAllOrderDetails();
		} else {
			return orders;
		}
	}

	@SuppressWarnings("unchecked")
	public long stampProfileWithOrder(Order order) throws ProfileNotFoundException {

		List<ProfileModel> modelList = client.getAllProfileDetails();

		Order bookedOrder = null;
		if (modelList.isEmpty()) {
			return service.stampProfileWithOrder(order);
		} else {
			long profileId = 0l;
			for (ProfileModel m : modelList) {
				if (m.getCriteriaValue().equals(order.getOrderType())) {
					bookedOrder = new Order(order.getOrderId(), order.getOrderNumber(), order.getOrderType(),
							m.getProfileType());
					profileId = m.getProfileId();

					template.opsForHash().put(HASH_KEY, order.getOrderId(), bookedOrder);
					service.stampProfileWithOrder(order);
					return profileId;
				}

			}
			throw new ProfileNotFoundException(order.getOrderType());

		}
	}

	@SuppressWarnings("unchecked")
	public Object findOrderById(long orderId) {

		return (template.opsForHash().get(HASH_KEY, orderId));
	}

	@SuppressWarnings("unchecked")
	public String deleteOrder(long orderId) {

		if (findOrderById(orderId) != null) {
			template.opsForHash().delete(HASH_KEY, orderId);
			service.deleteProfile(orderId);
			return "Order id " + Long.toString(orderId) + " deleted successfully";

		} else {
			return service.deleteProfile(orderId);
		}

	}

}
