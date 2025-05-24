package com.caplorik.smartexpensetracker.repository;

import com.caplorik.smartexpensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
