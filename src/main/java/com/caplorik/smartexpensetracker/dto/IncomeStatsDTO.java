package com.caplorik.smartexpensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeStatsDTO {
    private BigDecimal totalIncome;
    private BigDecimal totalSalaryIncome;
}

