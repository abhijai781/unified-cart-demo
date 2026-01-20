package com.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SailingCartSummary {
    private String shipCode;
    private String sailDate;
    private List<CartSummary> carts;
}
