package com.joaovellenich.kafka.data;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderData {
    private String id;
    private String ProductName;
    private BigDecimal value;
}
