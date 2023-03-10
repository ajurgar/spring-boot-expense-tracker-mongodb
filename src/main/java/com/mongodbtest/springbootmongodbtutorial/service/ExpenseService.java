package com.mongodbtest.springbootmongodbtutorial.service;

import com.mongodbtest.springbootmongodbtutorial.model.Expense;
import com.mongodbtest.springbootmongodbtutorial.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(() ->
                new RuntimeException(String.format("Cannot Find Expense by ID %s", expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expense);
    }

    public Expense getExpense(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Name - %s", name)));
    }

    public void deleteExpense(String id){
            expenseRepository.deleteById(id);
    }
}
