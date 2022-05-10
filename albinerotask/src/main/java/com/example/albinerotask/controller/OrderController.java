package com.example.albinerotask.controller;

import com.example.albinerotask.service.OrderService;
import com.example.albinerotask.dto.OrderDTO;
import com.example.albinerotask.request.OrderRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController(value = "orderController")
@RequestMapping
@Log4j2
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/api/order")
	@ResponseBody
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequest orderRequest) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.create(orderRequest));
	}

	@GetMapping("/api/order/{id}")
	@ResponseBody
	public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.get(id));
	}
}

