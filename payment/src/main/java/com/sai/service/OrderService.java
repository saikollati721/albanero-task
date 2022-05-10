package com.sai.service;

import com.sai.mapper.OrderMapper;
import com.sai.model.Orders;
import com.sai.dto.OrderDTO;
import com.sai.repository.OrderRepository;
import com.sai.request.ItemRequest;
import com.sai.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @Lazy}))
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDTO create(OrderRequest orderRequest) throws Exception {
        Long totalPrice = Long.valueOf(0);
        for(ItemRequest item: orderRequest.getItemList()){
            totalPrice += item.getPrice();
        };
        Orders order = orderMapper.map(orderRequest);
        order.setTotalPrice(totalPrice);
        order = orderRepository.save(order);
        OrderDTO orderDTO = orderMapper.mapDTO(order);
        return orderDTO;
    }

    public OrderDTO get(Long id) throws Exception {
        Orders order = this.orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found with" + id));
        OrderDTO orderDTO = orderMapper.mapDTO(order);
        return orderDTO;
    }
}
