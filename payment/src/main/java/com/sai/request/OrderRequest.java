package com.sai.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
	private String name;
	private List<ItemRequest> itemList;
}
