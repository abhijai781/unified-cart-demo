package com.commercecart.model;

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
public class CommerceCartItem extends CartItem {
    private Instant createdAt;

    public CommerceCartItem(String id, String name, Integer quantity, Integer unitPriceMinor, Integer totalPriceMinor, String imageUrl, String specialInstructions, Instant createdAt) {
        super(id, name, quantity, unitPriceMinor, totalPriceMinor, imageUrl, specialInstructions);
        this.createdAt = createdAt;
    }
}
