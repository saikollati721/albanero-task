package com.sai.controller;

import com.sai.dto.OrderDTO;
import com.sai.request.OrderRequest;
import com.sai.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.extern.log4j.Log4j2;

@RestController(value = "orderController")
@RequestMapping
@Log4j2
public class PaymentController {
	@Autowired
	OrderService orderService;

	
	@PostMapping("/api/payment")
	@ResponseBody
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequest orderRequest) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.create(orderRequest));
	}
	@GetMapping("/api/payment/{id}")
	@ResponseBody
	public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.get(id));
	}
}
