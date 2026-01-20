package com.roomservice.model;

import com.common.model.SailingStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sailing {
    private String shipCode;
    private String sailDate;
    private SailingStatus status;
    private Boolean isOnBoard;
}
