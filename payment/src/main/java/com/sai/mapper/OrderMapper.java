package com.sai.mapper;


import com.sai.dto.OrderDTO;
import com.sai.model.Orders;
import com.sai.request.OrderRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OrderMapper  {
    Orders map(OrderRequest orderRequest);
    @Mapping(target = "itemList", expression = "java(order.getItemList())")
    OrderDTO mapDTO(Orders order);
}
