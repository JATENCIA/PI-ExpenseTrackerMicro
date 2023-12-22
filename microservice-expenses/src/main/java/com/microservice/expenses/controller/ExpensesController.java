package com.microservice.expenses.controller;

import com.microservice.expenses.entities.Expenses;
import com.microservice.expenses.service.IExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    private IExpensesService expensesService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExpenses(@RequestBody Expenses expenses) {
        expensesService.save(expenses);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllExpense() {
        return ResponseEntity.ok(expensesService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Expenses> findById(@PathVariable Long id) {
        return ResponseEntity.ok(expensesService.findById(id));
    }

    @GetMapping("/search-by-category/{idCategory}")
    public ResponseEntity<?> findByIdCategories(@PathVariable Long idCategory) {
        return ResponseEntity.ok(expensesService.findByIdCategory(idCategory));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        expensesService.delete(id);
    }

}
