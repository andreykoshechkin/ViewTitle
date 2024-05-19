package com.example.viewtitle.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationData {

    private String name;
    private String INN;
    private BigDecimal category;
    private BigDecimal group;
    private String cusShortName;

}
