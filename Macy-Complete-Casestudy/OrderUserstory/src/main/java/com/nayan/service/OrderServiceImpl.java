package com.nayan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayan.DTO.ProfileModel;
import com.nayan.client.ProfileClient;
import com.nayan.exception.OrderNotFoundException;
import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.Order;
import com.nayan.repo.OrderRepository;

import lombok.extern.java.Log;

@Service
@Log
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProfileClient client;
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public long stampProfileWithOrder(Order order) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		Order bookedOrder = null;
		List<ProfileModel> modelList = client.getAllProfileDetails();
		long profileId = 0l;
		for (ProfileModel m : modelList) {
			if (m.getCriteriaValue().equals(order.getOrderType())) {
				bookedOrder = new Order(order.getOrderId(), order.getOrderNumber(), order.getOrderType(),
						m.getProfileType());
				profileId = m.getProfileId();
				log.info("Order saved successfully");
				orderRepo.save(bookedOrder);
				return profileId;

				
			}
			
		}
		throw new ProfileNotFoundException(order.getOrderType());
	}

	@Override
	public String deleteProfile(long orderId) {
		if (orderRepo.findById(orderId).isPresent()) {
			log.info("Order deleted successfully");

			orderRepo.deleteById(orderId);
			return "Order id " + Long.toString(orderId) + " deleted successfully";
		} else {
			throw new OrderNotFoundException(orderId);
		}
	}

	@Override
	public List<Order> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

}
