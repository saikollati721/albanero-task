package com.sai.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String name;
    private Long totalPrice;
    private List<ItemDTO> itemList;
}
