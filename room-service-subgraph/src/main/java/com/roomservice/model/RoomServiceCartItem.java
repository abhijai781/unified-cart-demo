package com.roomservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomServiceCartItem {
    private String id;
    private String name;
    private Integer quantity;
    private Integer unitPriceMinor;
    private Integer totalPriceMinor;
    private String imageUrl;
    private String specialInstructions;
    private Instant addedAt; // from UnifiedCartItem
}
