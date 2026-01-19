package com.roomservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartSummary {
    private UnifiedCartType cartType;
    private Integer itemCount;
    private Integer subTotalMinor;
    private CartAvailability availability;
}
