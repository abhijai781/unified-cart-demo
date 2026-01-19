package com.guest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private String accountId;
    private String name;
    private String email;
    private List<Sailing> sailings;
}
