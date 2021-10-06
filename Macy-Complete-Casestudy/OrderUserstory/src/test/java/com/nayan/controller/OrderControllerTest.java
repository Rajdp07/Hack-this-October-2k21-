package com.nayan.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nayan.DTO.ProfileModel;
import com.nayan.cache.OrderDaoCache;
import com.nayan.controller.OrderController;
import com.nayan.model.Order;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = OrderController.class)
@ActiveProfiles("test")
class OrderControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderDaoCache cache;
	
	@Autowired
	ObjectMapper mapper;
	
	Order order=new Order(1L,123,"OrderType","POS");
	List<Order> list=new ArrayList<>();
	ProfileModel model = new ProfileModel(100L, "Profile X", "ProfileType", "Criteria1", "POS", "Shipment");

	@Test
	void testStampProfileWithOrder() throws Exception {
		
		when(cache.stampProfileWithOrder(order)).thenReturn(100L);
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(order);
		mockMvc.perform(post("/order/add").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
	}
	

	@Test
	void testDeleteOrder() throws Exception {
		when(cache.deleteOrder(1)).thenReturn("deleted Successfully");
		this.mockMvc.perform(delete("/order/deleteorder/1")).equals(ResponseEntity.status(HttpStatus.OK).body("deleted Successfully"));
	}
	
	
	@Test
	void testGetAllOrderDetails() throws Exception {
		list.add(order);
		when(cache.getAllOrderDetails()).thenReturn(list);
		this.mockMvc.perform(get("/order/")).equals(ResponseEntity.status(HttpStatus.OK).body(list));
	}

}
