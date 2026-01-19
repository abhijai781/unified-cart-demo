package com.commercecart.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedCartSummary {
    private Integer totalItemCount;
    private Integer totalValueMinor;
    private String currencyCode;
    private List<SailingCartSummary> sailings;
}
