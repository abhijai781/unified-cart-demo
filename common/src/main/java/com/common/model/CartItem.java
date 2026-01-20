package com.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String id;
    private String name;
    private Integer quantity;
    private Integer unitPriceMinor;
    private Integer totalPriceMinor;
    private String imageUrl;
    private String specialInstructions;
}
