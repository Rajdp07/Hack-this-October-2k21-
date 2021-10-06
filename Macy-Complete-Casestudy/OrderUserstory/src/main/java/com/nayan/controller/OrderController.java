package com.nayan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayan.cache.OrderDaoCache;
import com.nayan.exception.OrderNotFoundException;
import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderDaoCache cache;

	@GetMapping("/")
	public ResponseEntity<List<Order>> getAllOrderDetails(){
		log.info("Order Details retrieved:: {}");
		return new ResponseEntity<List<Order>>(cache.getAllOrderDetails(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Long> stampProfileWithOrder(@Valid @RequestBody Order order) throws ProfileNotFoundException {
		log.info("Profile stamped with order :: {}", order);
		return new ResponseEntity<Long>(cache.stampProfileWithOrder(order), HttpStatus.OK);
	}

	@DeleteMapping("/deleteorder/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable long orderId) throws OrderNotFoundException {
		log.info("Order deleted with orderId :: {}", orderId);
		return new ResponseEntity<String>(cache.deleteOrder(orderId), HttpStatus.OK);
	}

}
