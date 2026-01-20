package com.roomservice.model;

import com.common.model.CartItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoomServiceCartItem extends CartItem {
    private Instant addedAt; // from UnifiedCartItem

    public RoomServiceCartItem(String id, String name, Integer quantity, Integer unitPriceMinor, Integer totalPriceMinor, String imageUrl, String specialInstructions, Instant addedAt) {
        super(id, name, quantity, unitPriceMinor, totalPriceMinor, imageUrl, specialInstructions);
        this.addedAt = addedAt;
    }
}
