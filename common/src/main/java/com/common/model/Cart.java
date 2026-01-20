package com.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private String cartId;
    private String accountId;
    private String shipCode;
    private String sailDate;
    private String stateRoom;
    private UnifiedCartType cartType;
    private Integer itemCount;
    private String menuId;
    private List<CartItem> items;
    private Integer subTotalMinor;
    private String currencyCode;
    private Boolean isPreOrder;
    private String scheduleDelivery;
    private CartAvailability availability;
}
