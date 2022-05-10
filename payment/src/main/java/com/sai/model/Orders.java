package com.sai.model;

import com.sai.dto.ItemDTO;
import com.sai.request.ItemRequest;
import com.sai.util.ObjectMapperService;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "total_price")
    private Long totalPrice;
    @Column(name = "item_list")
    private String itemList;


    public List<ItemDTO> getItemList() {
        return new ObjectMapperService().parseJson(itemList, List.class);
    }

    public void setItemList(List<ItemRequest> itemList) {
        this.itemList = new ObjectMapperService().convertToJson(itemList);
    }

}
