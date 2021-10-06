package com.nayan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nayan.DTO.ProfileModel;
import com.nayan.client.ProfileClient;
import com.nayan.exception.OrderNotFoundException;
import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.Order;
import com.nayan.repo.OrderRepository;
import com.nayan.service.OrderService;

import lombok.extern.java.Log;

@Log
@SpringBootTest
class OrderServiceImplTest {

	@MockBean
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@MockBean
	private ProfileClient client;

	List<ProfileModel> list = new ArrayList<>();
	Order bookOrder = new Order(1, 123, "OrderType", "POS");
	ProfileModel model = new ProfileModel(1L, "Profile X", "ProfileType", "Criteria1", "OrderType", "Shipment");

	@Test
	void testStampProfileWithOrder() {
		list.add(model);
		when(client.getAllProfileDetails()).thenReturn(list);
		String orderType = bookOrder.getOrderType();
		assertEquals(bookOrder.getOrderType(), model.getCriteriaValue());
		long profileId = model.getProfileId();
		when(orderRepository.save(bookOrder)).thenReturn(bookOrder);
		assertEquals(profileId, orderService.stampProfileWithOrder(bookOrder));

	}

	@Test
	void testStampProfileWithOrderNotFound() throws RuntimeException {
		log.info("*********Stamping Order with Profile Started********");
		ProfileModel model1 = new ProfileModel(2L, "Profile X", "ProfileType", "Criteria1", "OrderType1", "Shipment");
		list.add(model1);

		when(client.getAllProfileDetails()).thenReturn(list);
		String orderType = bookOrder.getOrderType();

		for (ProfileModel profileModel : list) {
			assertEquals(false, profileModel.getCriteriaValue().equals(bookOrder.getOrderType()));

		}

		Exception exception = assertThrows(RuntimeException.class, () -> orderService.stampProfileWithOrder(bookOrder));
		System.out.println(exception);
		String msg = "Could not find the Profile with order type: " + orderType;

		assertEquals(msg, exception.getMessage());

	}

	@Test
	void testDeleteProfile() {
		when(orderRepository.findById(bookOrder.getOrderId())).thenReturn(Optional.of(bookOrder));
		assertEquals("Order id 1 deleted successfully", orderService.deleteProfile(bookOrder.getOrderId()));
	}

	@Test
	void testDeleteProfileNotFound() throws Exception {
		when(orderRepository.findById(bookOrder.getOrderId())).thenReturn(Optional.empty());
		Exception exception = assertThrows(OrderNotFoundException.class,
				() -> orderService.deleteProfile(bookOrder.getOrderId()));
		assertEquals("Could not find the Order Id " + bookOrder.getOrderId(), exception.getMessage());

	}

	@Test
	void testGetAllOrderDetails() {
		List<Order> list = new ArrayList<>();
		list.add(bookOrder);
		when(orderRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), orderService.getAllOrderDetails().size());
	}

}
