package com.caplorik.smartexpensetracker.controller;

import com.caplorik.smartexpensetracker.model.Income;
import com.caplorik.smartexpensetracker.service.IncomeService;
import com.caplorik.smartexpensetracker.dto.IncomeStatsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
@CrossOrigin(origins = "*") // Keep CORS as it is for development
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService){
        this.incomeService=incomeService;
    }

    @GetMapping
    public List<Income> getAllIncomes(){
        return incomeService.getAllIncomes();
    }

    @PostMapping
    public Income createIncome(@RequestBody Income income){
        return incomeService.saveIncome(income);
    }

    @DeleteMapping("{id}")
    public void deleteIncome(@PathVariable Long id){
        incomeService.deleteIncome(id);
    }


    @GetMapping("/stats")
    public ResponseEntity<IncomeStatsDTO> getIncomeStats(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        IncomeStatsDTO stats = incomeService.getIncomeStatsForPeriod(year, month);
        return ResponseEntity.ok(stats);
    }
}
