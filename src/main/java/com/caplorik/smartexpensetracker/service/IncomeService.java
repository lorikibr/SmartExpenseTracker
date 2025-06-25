package com.caplorik.smartexpensetracker.service;

import com.caplorik.smartexpensetracker.model.Income;
import com.caplorik.smartexpensetracker.repository.IncomeRepository;
import com.caplorik.smartexpensetracker.dto.IncomeStatsDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> getAllIncomes(){
        return incomeRepository.findAll();
    }

    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    public void deleteIncome(Long id){
        incomeRepository.deleteById(id);
    }


    public IncomeStatsDTO getIncomeStatsForPeriod(Integer year, Integer month) {
        LocalDate startDate;
        LocalDate endDate;

        LocalDate now = LocalDate.now();

        // Determine the start and end dates based on the provided year and month
        if (year != null && month != null) {
            startDate = LocalDate.of(year, month, 1);
            endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
        } else if (year != null) {
            startDate = LocalDate.of(year, 1, 1);
            endDate = LocalDate.of(year, 12, 31);
        } else {
            startDate = now.with(TemporalAdjusters.firstDayOfMonth());
            endDate = now.with(TemporalAdjusters.lastDayOfMonth());
        }

        List<Income> incomes = incomeRepository.findByDateBetween(startDate, endDate);

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalSalaryIncome = BigDecimal.ZERO;

        for (Income income : incomes) {
            BigDecimal incomeAmount = BigDecimal.valueOf(income.getAmount());
            totalIncome = totalIncome.add(incomeAmount);

            if ("Salary".equalsIgnoreCase(income.getSource())) {
                totalSalaryIncome = totalSalaryIncome.add(incomeAmount);
            }
        }

        return new IncomeStatsDTO(totalIncome, totalSalaryIncome);
    }
}
